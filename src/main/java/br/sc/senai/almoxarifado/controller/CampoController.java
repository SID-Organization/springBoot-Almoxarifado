package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.CampoDTO;
import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.service.CampoService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/almoxarifado/campos")
public class CampoController {

    @Autowired
    CampoService campoService;

    @GetMapping
    public ResponseEntity<List<Campo>> findAll() {

        List<Campo> listaCampos = campoService.findAll();

        return ResponseEntity.ok(listaCampos);
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CampoDTO campoDTO) {
        Campo campo = new Campo();
        BeanUtils.copyProperties(campoDTO, campo);

        Campo campoSalvo = campoService.save(campo);

        return ResponseEntity.ok(campoSalvo);
    }

}
