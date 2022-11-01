package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.OcorrenciaDTO;
import br.sc.senai.almoxarifado.model.entities.Ocorrencia;
import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.service.ItemService;
import br.sc.senai.almoxarifado.model.service.OcorrenciaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/almoxarifado/ocorrencias")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;


    @GetMapping
    public ResponseEntity<List<Ocorrencia>> findAll() {
        List<Ocorrencia> listaOcorrencias = ocorrenciaService.findAll();
        return ResponseEntity.ok(listaOcorrencias);
    }

//    @GetMapping("/{matricula}")
//    public ResponseEntity<Object> findByPessoa(@PathVariable(value = "matricula") Pessoa pessoa) {
//        if (ocorrenciaService.findByPessoa(pessoa).isEmpty()) {
//            return ResponseEntity.status(404).body("Não foi encontrado ocorrencia com a pessoa " + pessoa.getNome());
//        } else {
//            return ResponseEntity.ok(ocorrenciaService.findByPessoa(pessoa));
//        }
//    }
//
//    @GetMapping("/item/{idItem}")
//    public ResponseEntity<Object> findByItem(@PathVariable(value = "idItem") Long idItem) {
//        if (ocorrenciaService.findByIdItem(idItem).isEmpty()) {
//            return ResponseEntity.status(404).body("Não foi encontrado ocorrencia com o item " + idItem);
//        } else {
//            return ResponseEntity.ok(ocorrenciaService.findByIdItem(idItem));
//        }
//    }
//
//    @GetMapping("/reserva/{idReserva}")
//    public ResponseEntity<Object> findByReserva(@PathVariable(value = "idReserva") Long idReserva) {
//        if (ocorrenciaService.findByIdReserva(idReserva).isEmpty()) {
//            return ResponseEntity.status(404).body("Não foi encontrado ocorrencia com a reserva " + idReserva);
//        } else {
//            return ResponseEntity.ok(ocorrenciaService.findByIdReserva(idReserva));
//        }
//    }
//
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid OcorrenciaDTO ocorrenciaDTO) {
        if (ocorrenciaDTO.getDescricao() == null) {
            return ResponseEntity.status(400).body("A ocorrência deve ter uma descrição");
        }

        Ocorrencia ocorrencia;
        BeanUtils.copyProperties(ocorrenciaDTO, ocorrencia = new Ocorrencia());
        Ocorrencia ocorrenciaSalva = ocorrenciaService.save(ocorrencia);
        return ResponseEntity.ok(ocorrenciaSalva);
    }
}

