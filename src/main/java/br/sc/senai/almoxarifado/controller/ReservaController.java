package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.ReservaDTO;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.model.entities.Status;
import br.sc.senai.almoxarifado.model.service.OcorrenciaService;
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

    @Autowired
    OcorrenciaService ocorrenciaService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<Object> findAll() {
        List<Reserva> listaReservas = reservaService.findAll();
        if (listaReservas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma reserva encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(listaReservas);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Reserva> save(@RequestBody @Valid ReservaDTO reservaDTO) {
        Reserva reserva = new Reserva();
        BeanUtils.copyProperties(reservaDTO, reserva);
        reserva.setStatus(Status.ATIVO);
        Reserva reservaSalva = reservaService.save(reserva);
        for (ReservaItem reservaItem : reservaDTO.getReservaItem()) {
            reservaItem.setIdReserva(reservaSalva);
            System.out.println("Reserva item: " + reservaItem.getIdItem().getId());
            reservaItemService.save(reservaItem);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(reserva);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/status/{status}")
    public ResponseEntity<Object> findByStatus(@PathVariable(value = "status") Status status) {
        List<Reserva> reservasList = reservaService.findByStatus(status);
        if (reservasList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o status " + status + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservasList);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o id " + id + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(reservaItemService.findByIdReserva(reserva.get()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "id") Integer id) {
        Reserva reserva = reservaService.findById(id).get();
        List<ReservaItem> listaReservaItem = reservaItemService.findByIdReserva(reserva);
        if (listaReservaItem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o id " + id + ".");
        }
//
//
//        for (ReservaItem reservaItem : listaReservaItem) {
//            if (ocorrenciaService.findByReservaItem(reservaItem) == null) {
//                reservaItemService.deleteById(reservaItem.getIdReservaItem());
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                        .body("Não foi possível excluir a reserva com o id " + id + " pois possui ocorrências.");
//            }
//        }
        reservaService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Reserva com o id " + id + " foi deletado com sucesso");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody @Valid ReservaDTO reservaDTO) {
        Optional<Reserva> reserva = reservaService.findById(id);
        if (reserva.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o id " + id + ".");
        }
        Reserva reservaAtualizada = reserva.get();
        BeanUtils.copyProperties(reservaDTO, reservaAtualizada);
        reservaService.save(reservaAtualizada);
        return ResponseEntity.status(HttpStatus.OK).body(reservaAtualizada);
    }
}
