package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.PessoaDTO;
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

    @GetMapping
    public ResponseEntity<Object> findAll(Sort sort) {
        List<Pessoa> listaPessoas = pessoaService.findAll(sort);

        if (listaPessoas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhuma pessoa encontrada");
        }

        return ResponseEntity.status(HttpStatus.OK).body(listaPessoas);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Object> findById(@PathVariable(value = "matricula") Long matricula) {
        Optional<Pessoa> pessoa = pessoaService.findById(matricula);
        if (pessoa.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com a matricula " + matricula);
        } else {
            return ResponseEntity.ok(pessoa.get());
        }
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Object> deleteById(@PathVariable(value = "matricula") Long matricula) {
        if (pessoaService.existsById(matricula)) {
            pessoaService.deleteById(matricula);
            return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o matricula " + matricula + " foi deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o matricula " + matricula);
        }
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid PessoaDTO pessoaDTO){
        if (pessoaService.existsById(pessoaDTO.getMatricula())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Pessoa com o matricula " + pessoaDTO.getMatricula() + " já existe");
        }

        Pessoa pessoa;
        BeanUtils.copyProperties(pessoaDTO, pessoa = new Pessoa());
        pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<Object> update(@PathVariable(value = "matricula") Long matricula, @RequestBody @Valid PessoaDTO pessoaDTO) {
        Optional<Pessoa> pessoaOptional = pessoaService.findById(matricula);
        if (pessoaOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado pessoa com o matricula " + matricula);
        }

        Pessoa pessoa = pessoaOptional.get();
        BeanUtils.copyProperties(pessoaDTO, pessoa);
        pessoaService.save(pessoa);
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa com o matricula " + matricula + " foi atualizada com sucesso");
    }

}
