package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/almoxarifado/reserva")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findAll());
    }
}
