package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import br.sc.senai.almoxarifado.model.service.EstoqueCamposService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/almoxarifado/estoque_campos")
public class EstoqueCamposController {

    @Autowired
    private EstoqueCamposService estoqueCamposService;

    @GetMapping
    public ResponseEntity<List<EstoqueCampos>> findAll(){
        List<EstoqueCampos> listaEstoqueCampos = estoqueCamposService.findAll();

        return ResponseEntity.ok(listaEstoqueCampos);
    }
}
