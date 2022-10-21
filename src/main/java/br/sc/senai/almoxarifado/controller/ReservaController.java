package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ReservaDTO;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.Status;
import br.sc.senai.almoxarifado.model.service.ReservaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

    @PostMapping
    public ResponseEntity<Reserva> save(ReservaDTO reservaDTO) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime dateNow = LocalDateTime.now();
        LocalDateTime reservaLocalDate = LocalDateTime.ofInstant(
                reservaDTO.getDataRetirada().toInstant(), ZoneId.systemDefault());
        if (dateNow.isAfter(reservaLocalDate)){

        }

        Reserva reserva = new Reserva();

        BeanUtils.copyProperties(reservaDTO, reserva);
        reservaService.save(reserva);
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
