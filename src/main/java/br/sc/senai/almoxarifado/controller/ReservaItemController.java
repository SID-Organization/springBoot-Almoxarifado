package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.model.service.ReservaItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almoxarifado/reserva_itens")
public class ReservaItemController {

    @Autowired
    ReservaItemService reservaItemService;

    @GetMapping
    public ResponseEntity<Object> findAll(){
        List<ReservaItem> listaReservasItens = reservaItemService.findAll();
        if(listaReservasItens.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado nenhum item de reserva.");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(listaReservasItens);
    }

}
