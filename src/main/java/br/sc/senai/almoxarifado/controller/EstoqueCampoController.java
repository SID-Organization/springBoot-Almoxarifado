package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.EstoqueCampoDTO;
import br.sc.senai.almoxarifado.DTO.EstoqueDTO;
import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import br.sc.senai.almoxarifado.model.service.EstoqueCamposService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/almoxarifado/estoque_campos")
public class EstoqueCampoController {

    @Autowired
    private EstoqueCamposService estoqueCamposService;

    @GetMapping
    public ResponseEntity<List<EstoqueCampos>> findAll(){
        List<EstoqueCampos> listaEstoqueCampos = estoqueCamposService.findAll();

        return ResponseEntity.ok(listaEstoqueCampos);
    }

    @PostMapping
    public ResponseEntity<EstoqueCampos> save(@RequestBody @Valid EstoqueCampoDTO estoqueCampoDTO){
        EstoqueCampos estoqueCampo = new EstoqueCampos();
        System.out.println(estoqueCampoDTO.getValorCampo());

        BeanUtils.copyProperties(estoqueCampoDTO, estoqueCampo);
        estoqueCamposService.save(estoqueCampo);

        return ResponseEntity.ok(estoqueCampo);
    }
}
