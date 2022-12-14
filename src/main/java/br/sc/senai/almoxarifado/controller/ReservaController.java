package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ReservaDTO;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.model.entities.Status;
import br.sc.senai.almoxarifado.model.service.ReservaItemService;
import br.sc.senai.almoxarifado.model.service.ReservaService;
import org.atmosphere.config.service.Put;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almoxarifado/reservas")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @Autowired
    ReservaItemService reservaItemService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findAll());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Reserva> save(@RequestBody @Valid ReservaDTO reservaDTO) {
        System.out.println(reservaDTO.toString());
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaDTO, reserva);
        Reserva reservaSalva = reservaService.save(reserva);
        for (ReservaItem reservaItem : reservaDTO.getReservaItem()) {
            reservaItem.setIdReserva(reservaSalva);
            reservaItemService.save(reservaItem);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{status}")
    public ResponseEntity<Object> findByStatus(@PathVariable(value = "status") Status status) {
        List<Reserva> reservasList = reservaService.findByStatus(status);
        if (reservasList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("N??o foi encontrado reserva com o status " + status + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservasList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("N??o foi encontrado reserva com o id " + id + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservaItemService.findByIdReserva(reserva.get()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (reservaService.existsById(id)) {
            reservaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva com o id " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("N??o foi encontrado reserva com o id " + id);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody @Valid ReservaDTO reservaDTO) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("N??o foi encontrado reserva com o id " + id + ".");
        }
        Reserva reservaAtualizada = reserva.get();
        BeanUtils.copyProperties(reservaDTO, reservaAtualizada);
        reservaService.save(reservaAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(reservaAtualizada);
    }
}
