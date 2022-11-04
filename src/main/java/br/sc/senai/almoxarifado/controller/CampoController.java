package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.CampoDTO;
import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import br.sc.senai.almoxarifado.model.service.CampoService;
import br.sc.senai.almoxarifado.model.service.ValorPredefinidoService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almoxarifado/campos")
public class CampoController {

    @Autowired
    CampoService campoService;

    @Autowired
    ValorPredefinidoService valorPredefinidoService;

    @GetMapping
    public ResponseEntity<List<Campo>> findAll() {

        List<Campo> listaCampos = campoService.findAll();

        if (listaCampos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(listaCampos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {

        Optional<Campo> campo = campoService.findById(id);

        if (campo.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Campo não encontrado");
        }

        return ResponseEntity.ok(valorPredefinidoService.findByCampo(campo.get()));
    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid CampoDTO campoDTO) {

        System.out.println(campoDTO.toString());
        Optional<Campo> campoOptional = campoService.findByNomeCampo(campoDTO.getNomeCampo());

        if(campoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.FOUND).body("Campo já cadastrado!");
        }

        Campo campo = new Campo();
        BeanUtils.copyProperties(campoDTO, campo);
        Campo campoSalvo = campoService.save(campo);

        for(ValorPredefinido valor : campoDTO.getValores()){
            System.out.println(valor.getValorPredefinido());
            valor.setIdCampo(campoSalvo);
            valorPredefinidoService.save(valor);
        }

        return ResponseEntity.ok(campoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @RequestBody @Valid CampoDTO campoDTO) {

        Optional<Campo> campo = campoService.findById(id);

        if (campo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(campoDTO, campo.get());
        Campo campoSalvo = campoService.save(campo.get());

        for(ValorPredefinido valor : campoDTO.getValores()){
            System.out.println(valor.getValorPredefinido());
            valor.setIdCampo(campoSalvo);
            valorPredefinidoService.save(valor);
        }

        return ResponseEntity.ok(campoSalvo);
    }

}
