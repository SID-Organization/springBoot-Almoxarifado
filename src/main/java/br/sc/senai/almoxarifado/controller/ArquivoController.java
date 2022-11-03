package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ArquivoDTO;
import br.sc.senai.almoxarifado.DTO.ReservaDTO;
import br.sc.senai.almoxarifado.model.entities.Arquivo;
import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.service.ArquivoService;
import org.atmosphere.config.service.Post;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/almoxarifado/arquivos")
public class ArquivoController {
    @Autowired
    ArquivoService arquivoService;

    @GetMapping
    public ResponseEntity<List> findAll() {
        List listaArquivos = arquivoService.findAll();

        if (listaArquivos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(listaArquivos);
    }

    @PostMapping
    public ResponseEntity<Arquivo> save(@RequestBody @Valid ArquivoDTO arquivoDTO) {
        System.out.println(arquivoDTO.toString());
        Arquivo arquivo = new Arquivo();
        BeanUtils.copyProperties(arquivoDTO, arquivo);
        System.out.println(arquivo);
        Arquivo arquivoSalvo = arquivoService.save(arquivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(arquivoSalvo);
    }


}
