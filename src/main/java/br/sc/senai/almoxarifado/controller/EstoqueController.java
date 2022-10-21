package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.EstoqueDTO;
import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import br.sc.senai.almoxarifado.model.service.EstoqueCamposService;
import br.sc.senai.almoxarifado.model.service.EstoqueService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/almoxarifado/estoques")
public class EstoqueController {

    @Autowired
    EstoqueService estoqueService;

    @GetMapping
    public ResponseEntity<List<Estoque>> findAll(){

        List<Estoque> listaEstoques = estoqueService.findAll();

        return ResponseEntity.ok(listaEstoques);
    }

    @PostMapping
    public ResponseEntity<Estoque> save(@RequestBody @Valid EstoqueDTO estoqueDTO){
        Estoque estoque = new Estoque();

        BeanUtils.copyProperties(estoqueDTO, estoque);

        EstoqueCamposService estoqueCamposService;

        for(EstoqueCampos estoqueCampos : estoque.getListaCampos()){

        }

        Estoque estoqueSalvo = estoqueService.save(estoque);

        return ResponseEntity.ok(estoqueSalvo);
    }
}
