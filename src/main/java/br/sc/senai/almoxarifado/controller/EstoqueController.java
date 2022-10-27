package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.EstoqueDTO;
import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.service.EstoqueCamposService;
import br.sc.senai.almoxarifado.model.service.EstoqueService;
import org.atmosphere.config.service.Get;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almoxarifado/estoques")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @Autowired
    EstoqueCamposService estoqueCamposService;

    @GetMapping
    public ResponseEntity<List<Estoque>> findAll(){

        List<Estoque> listaEstoques = estoqueService.findAll();

        return ResponseEntity.ok(listaEstoques);
    }

    @PostMapping
    public ResponseEntity<Estoque> save(@RequestBody @Valid EstoqueDTO estoqueDTO){
        System.out.println(estoqueDTO);
        Estoque estoque = new Estoque();

        BeanUtils.copyProperties(estoqueDTO, estoque);
        System.out.println(estoque);

        Estoque estoqueSalvo = estoqueService.save(estoque);

        for (EstoqueCampos estoqueCampos : estoqueDTO.getEstoqueCampos()) {
            estoqueCampos.setIdEstoque(estoqueSalvo);
            estoqueCamposService.save(estoqueCampos);
            System.out.println(estoqueCampos);
        }

        System.out.println(estoqueSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(estoque);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id){
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (estoque.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado estoque com o id " + id + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(estoqueCamposService.findByIdEstoque(estoque.get()));
    }
}
