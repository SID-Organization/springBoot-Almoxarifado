package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.model.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/almoxarifado/estoques")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<Estoque>> findAll(){

        List<Estoque> listaEstoques = estoqueService.findAll();

        return ResponseEntity.ok(listaEstoques);
    }
}
