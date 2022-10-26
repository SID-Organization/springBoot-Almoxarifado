package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ValorPredefinidoDTO;
import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import br.sc.senai.almoxarifado.model.service.ValorPredefinidoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almoxarifado/valor_predefinido")
public class ValorPredefinidoController {
    @Autowired
    ValorPredefinidoService valorPredefinidoService;

    @GetMapping
    public ResponseEntity<List<ValorPredefinido>> findAll(){
        List<ValorPredefinido> listaValorPredefinido = valorPredefinidoService.findAll();
        return ResponseEntity.ok(listaValorPredefinido);
    }

    @GetMapping("/campo/{id}")
    public ResponseEntity<List<ValorPredefinido>> findByCampo(@PathVariable Campo idCampo){
        List<ValorPredefinido> listaValorPredefinido = valorPredefinidoService.findByCampo(idCampo);
        return ResponseEntity.ok(listaValorPredefinido);
    }

    @PostMapping()
    public ResponseEntity<ValorPredefinido> save(@RequestBody ValorPredefinidoDTO valorPredefinidoDTO){
        ValorPredefinido valorPredefinido = new ValorPredefinido();
        BeanUtils.copyProperties(valorPredefinidoDTO, valorPredefinido);
        System.out.println("1 " + valorPredefinidoDTO.getIdCampo());
        ValorPredefinido valorPredefinidoSalvo = valorPredefinidoService.save(valorPredefinido);
        System.out.println("2 " + valorPredefinidoSalvo.getIdCampo());
        return ResponseEntity.ok(valorPredefinidoSalvo);
    }
}
