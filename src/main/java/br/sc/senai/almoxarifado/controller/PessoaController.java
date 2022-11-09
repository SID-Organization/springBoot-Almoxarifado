package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.PessoaDTO;
import br.sc.senai.almoxarifado.model.entities.Cargo;
import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/almoxarifado/pessoas")
public class PessoaController {

    @Autowired
    PessoaService pessoaService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(Sort sort) {
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll(sort));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{matricula}")
    public ResponseEntity<Object> findById(@PathVariable(value = "matricula") String matricula) {
        Optional<Pessoa> pessoa = pessoaService.findByMatricula(matricula);
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com a matricula " + matricula);
        } else {
            return ResponseEntity.ok(pessoa.get());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{matricula}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "matricula") String matricula) {
        if (pessoaService.existsByMatricula(matricula)) {
            pessoaService.deleteByMatricula(matricula);
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o matricula " + matricula + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o matricula " + matricula);
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO pessoaDTO){
        if (pessoaService.existsByMatricula(pessoaDTO.getMatricula())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Pessoa com o matricula " + pessoaDTO.getMatricula() + " já existe");
        }

        Pessoa pessoa;
        BeanUtils.copyProperties(pessoaDTO, pessoa = new Pessoa());
        pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{matricula}")
    public ResponseEntity<Object> update(@PathVariable(value = "matricula") String matricula, @RequestBody @Valid PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoaOptional = pessoaService.findByMatricula(matricula);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o matricula " + matricula);
        }

        Pessoa pessoa = pessoaOptional.get();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o matricula " + matricula + " foi atualizado com sucesso");
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/cargo/{cargo}")
    public ResponseEntity<Object> findByCargo(@PathVariable(value = "cargo") Cargo cargo) {
        List<Pessoa> pessoas = pessoaService.findAllByCargo(cargo);
        if (pessoas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o cargo " + cargo);
        } else {
            return ResponseEntity.ok(pessoas);
        }
    }

}
