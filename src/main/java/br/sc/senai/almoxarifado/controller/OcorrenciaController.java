package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/almoxarifado/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.ok(ocorrenciaService.findAll());
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Object> findByPessoa(@PathVariable(value = "matricula") Pessoa pessoa) {
        if (ocorrenciaService.findByPessoa(pessoa).isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado ocorrencia com a pessoa " + pessoa.getNome());
        } else {
            return ResponseEntity.ok(ocorrenciaService.findByPessoa(pessoa));
        }
    }

    @GetMapping("/item/{idItem}")
    public ResponseEntity<Object> findByItem(@PathVariable(value = "idItem") Long idItem) {
        if (ocorrenciaService.findByIdItem(idItem).isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado ocorrencia com o item " + idItem);
        } else {
            return ResponseEntity.ok(ocorrenciaService.findByIdItem(idItem));
        }
    }

    @GetMapping("/reserva/{idReserva}")
    public ResponseEntity<Object> findByReserva(@PathVariable(value = "idReserva") Long idReserva) {
        if (ocorrenciaService.findByIdReserva(idReserva).isEmpty()) {
            return ResponseEntity.status(404).body("Não foi encontrado ocorrencia com a reserva " + idReserva);
        } else {
            return ResponseEntity.ok(ocorrenciaService.findByIdReserva(idReserva));
        }
    }


}
