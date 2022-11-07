package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ItemDTO;
import br.sc.senai.almoxarifado.model.entities.Arquivo;
import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.model.entities.Item;
import br.sc.senai.almoxarifado.model.service.ArquivoService;
import br.sc.senai.almoxarifado.model.service.EspacoOrganizacionalService;
import br.sc.senai.almoxarifado.model.service.ItemService;
import br.sc.senai.almoxarifado.model.utils.ItemUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/almoxarifado/itens")
public class ItemController {

    @Autowired
    ItemService itemService;

    @Autowired
    ArquivoService arquivoService;

    @Autowired
    EspacoOrganizacionalService espacoOrganizacionalService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Object> save(
            @RequestParam("item") @Valid String itemJson,
            @RequestParam("image") MultipartFile file,
            @RequestParam(value = "additionalImages", required = false) MultipartFile[] additionalImages
    ) {
        ItemUtil itemUtil = new ItemUtil();

        Item item = itemUtil.convertJsonToModel(itemJson);

        try {
            item.setFotoIlustrativa(file.getBytes());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter a imagem");
        }
        item.setQuantidadeItem(1);
        Item itemSalvo = itemService.save(item);

        if (additionalImages != null) {
            try {
                for (MultipartFile additionalImage : additionalImages) {
                    Arquivo arquivo = new Arquivo();
                    arquivo.setNomeArquivo(additionalImage.getOriginalFilename());
                    arquivo.setTipoArquivo(additionalImage.getContentType());
                    arquivo.setArquivo(additionalImage.getBytes());
                    arquivo.setIdItem(itemSalvo);

                    arquivoService.save(arquivo);
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro ao converter a imagem");
            }
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Item>> findAll() {

        List<Item> listaItens = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listaItens);
    }

//    @GetMapping("/{classificacao}")
//    public ResponseEntity<Object> findByClassificacao(@PathVariable(value = "classificacao") String classificacao) {
//        List<Item> itemList = itemService.findByClassificacao(classificacao);
//        if (itemList.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                    .body("Não foi encontrado item com a classificação " + classificacao);
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(itemList);
//    }
//
//    @GetMapping("/{descartavel}")
//    public ResponseEntity<Object> findByItemDescartavel(@PathVariable(value = "descartavel") Integer descartavel) {
//        List<Item> itemList = itemService.findByItemDescartavel(descartavel);
//        if (itemList.isEmpty()) {
//            if (descartavel == 1) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Não há itens descartáveis");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Não há itens não descartáveis");
//            }
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(itemList);
//    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id) {
        if (!itemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado item com o id " + id);
        }
        itemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item com id " + id + " deletado com sucesso");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Long id, @RequestBody ItemDTO itemDTO) {
        if (!itemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado item com o id " + id);
        }
        Item item = itemService.findById(id).get();
        BeanUtils.copyProperties(itemDTO, item);
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.OK).body(item);
    }
}
