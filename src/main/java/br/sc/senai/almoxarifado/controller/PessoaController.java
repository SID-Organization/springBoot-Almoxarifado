package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.PessoaDTO;
import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.service.PessoaService;
import org.atmosphere.config.service.Put;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/almoxarifado/pessoa")
public class PessoaController {
    PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(Sort sort) {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll(sort));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Object> findById(@PathVariable(value = "matricula") String matricula) {
        Optional<Pessoa> pessoa = service.findByMatricula(matricula);
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com a matricula " + matricula);
        } else {
            return ResponseEntity.ok(pessoa.get());
        }
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "matricula") String matricula) {
        if (service.existsByMatricula(matricula)) {
            service.deleteByMatricula(matricula);
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o matricula " + matricula + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o matricula " + matricula);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO pessoaDTO){
        if (service.existsByMatricula(pessoaDTO.getMatricula())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Pessoa com o matricula " + pessoaDTO.getMatricula() + " já existe");
        }

        Pessoa pessoa;
        BeanUtils.copyProperties(pessoaDTO, pessoa = new Pessoa());
        service.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> update(@PathVariable(value = "matricula") String matricula, @RequestBody @Valid PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoaOptional = service.findByMatricula(matricula);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o matricula " + matricula);
        }

        Pessoa pessoa = pessoaOptional.get();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        service.save(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o matricula " + matricula + " foi atualizado com sucesso");
    }

}
