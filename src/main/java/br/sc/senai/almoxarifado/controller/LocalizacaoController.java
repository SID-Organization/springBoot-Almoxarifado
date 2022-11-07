package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.LocalizacaoDTO;
import br.sc.senai.almoxarifado.model.entities.Localizacao;
import br.sc.senai.almoxarifado.model.service.LocalizacaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/almoxarifado/estoque_campos")
public class LocalizacaoController {

    @Autowired
    private LocalizacaoService localizacaoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Localizacao>> findAll(){
        List<Localizacao> listaEstoqueCampos = localizacaoService.findAll();

        return ResponseEntity.ok(listaEstoqueCampos);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Localizacao> save(@RequestBody @Valid LocalizacaoDTO localizacaoDTO){
        Localizacao estoqueCampo = new Localizacao();
        System.out.println(localizacaoDTO.getValorCampo());

        BeanUtils.copyProperties(localizacaoDTO, estoqueCampo);
        localizacaoService.save(estoqueCampo);

        return ResponseEntity.ok(estoqueCampo);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{id}")
    public ResponseEntity<Localizacao> update(@PathVariable Integer id, @RequestBody @Valid LocalizacaoDTO localizacaoDTO){
        Localizacao localizacao = new Localizacao();
        BeanUtils.copyProperties(localizacaoDTO, localizacao);
        localizacao.setIdLocalizacao(id);
        localizacaoService.save(localizacao);

        return ResponseEntity.ok(localizacao);
    }
}
