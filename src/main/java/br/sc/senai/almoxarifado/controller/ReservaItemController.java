package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.model.service.ReservaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/almoxarifado/reserva_itens")
public class ReservaItemController {

    @Autowired
    ReservaItemService reservaItemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<ReservaItem>> findAll(){
        List<ReservaItem> listaReservasItens = reservaItemService.findAll();
        return ResponseEntity.ok(listaReservasItens);
    }

}
