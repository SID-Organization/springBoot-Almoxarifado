package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ItemDTO;
import br.sc.senai.almoxarifado.model.entities.Item;
import br.sc.senai.almoxarifado.model.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/almoxarifado/item")
public class ItemController {

    ItemService itemService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid ItemDTO itemDTO){
        Item item = new Item();
        BeanUtils.copyProperties(itemDTO, item);
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @GetMapping
    public ResponseEntity<Object> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(itemService.findAll());
    }

    @GetMapping("/{classificacao}")
    public ResponseEntity<Object> findByClassificacao(@PathVariable(value = "classificacao") String classificacao){
        List<Item> itemList = itemService.findByClassificacao(classificacao);
        if (itemList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado item com a classificação " + classificacao);
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }

    @GetMapping("/{descartavel}")
    public ResponseEntity<Object> findByItemDescartavel(@PathVariable(value = "descartavel") Integer descartavel){
        List<Item> itemList = itemService.findByItemDescartavel(descartavel);
        if (itemList.isEmpty()) {
            if(descartavel == 1){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Não há itens descartáveis");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Não há itens não descartáveis");
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(itemList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Long id){
        if (!itemService.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado item com o id " + id);
        }
        itemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Item com id " + id + " deletado com sucesso");
    }

}