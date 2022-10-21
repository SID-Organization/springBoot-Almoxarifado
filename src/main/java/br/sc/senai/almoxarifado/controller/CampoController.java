package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.service.CampoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/almoxarifado/campos")
public class CampoController {

    @Autowired
    CampoService campoService;

    @GetMapping
    public ResponseEntity<List<Campo>> findAll(){

        List<Campo> listaCampos = campoService.findAll();

        return ResponseEntity.ok(listaCampos);
    }

}
