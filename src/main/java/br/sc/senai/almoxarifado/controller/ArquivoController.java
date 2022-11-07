package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ArquivoDTO;
import br.sc.senai.almoxarifado.DTO.ReservaDTO;
import br.sc.senai.almoxarifado.model.entities.Arquivo;
import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.Item;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.service.ArquivoService;
import br.sc.senai.almoxarifado.model.service.ItemService;
import org.atmosphere.config.service.Post;
import org.atmosphere.config.service.Put;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almoxarifado/arquivos")
public class ArquivoController {
    @Autowired
    ArquivoService arquivoService;

    @Autowired
    ItemService itemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List> findAll() {
        List listaArquivos = arquivoService.findAll();

        if (listaArquivos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(listaArquivos);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/item/{id}")
    public ResponseEntity<List> findAllByIdItem(@PathVariable("id") Long id) {

        Optional<Item> item = itemService.findById(id);

        List listaArquivos = arquivoService.findAllByItem_IdItem(item.get());

        return ResponseEntity.ok(listaArquivos);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Arquivo> save(@RequestBody @Valid ArquivoDTO arquivoDTO) {
        System.out.println(arquivoDTO.toString());
        Arquivo arquivo = new Arquivo();
        BeanUtils.copyProperties(arquivoDTO, arquivo);
        System.out.println(arquivo);
        Arquivo arquivoSalvo = arquivoService.save(arquivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(arquivoSalvo);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Arquivo> update(
            @PathVariable(value = "id") Integer id,
            @RequestParam("arquivo") MultipartFile file
    ) {
        Arquivo arquivo = arquivoService.findById(id).get();
        try {
            arquivo.setArquivo(file.getBytes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        try {
            Arquivo arquivoSalvo = arquivoService.save(arquivo);
            return ResponseEntity.status(HttpStatus.OK).body(arquivoSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}
