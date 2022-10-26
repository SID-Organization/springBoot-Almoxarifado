package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ReservaDTO;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.model.entities.Status;
import br.sc.senai.almoxarifado.model.service.ReservaItemService;
import br.sc.senai.almoxarifado.model.service.ReservaService;
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

    @GetMapping
    public ResponseEntity<List<Reserva>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(reservaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Reserva> save(@RequestBody @Valid ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaDTO, reserva);
        Reserva reservaSalva = reservaService.save(reserva);
        for (ReservaItem reservaItem : reservaDTO.getReservaItem()) {
            reservaItem.setIdReserva(reservaSalva);
            reservaItemService.save(reservaItem);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @GetMapping("/{status}")
    public ResponseEntity<Object> findByStatus(@PathVariable(value = "status") Status status) {
        List<Reserva> reservasList = reservaService.findByStatus(status);
        if (reservasList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o status " + status + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservasList);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o id " + id + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservaItemService.findByIdReserva(reserva.get()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        if (reservaService.existsById(id)) {
            reservaService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("Reserva com o id " + id + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado reserva com o id " + id);
        }
    }
}
