package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.EspacoOrganizacionalDTO;
import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.model.entities.Localizacao;
import br.sc.senai.almoxarifado.model.service.LocalizacaoService;
import br.sc.senai.almoxarifado.model.service.EspacoOrganizacionalService;
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
public class EspacoOrganizacionalController {

    @Autowired
    EspacoOrganizacionalService espacoOrganizacionalService;

    @Autowired
    LocalizacaoService localizacaoService;

    @GetMapping
    public ResponseEntity<List<EspacoOrganizacional>> findAll(){

        List<EspacoOrganizacional> listaEspacoOrganizacionals = espacoOrganizacionalService.findAll();

        return ResponseEntity.ok(listaEspacoOrganizacionals);
    }

    @PostMapping
    public ResponseEntity<EspacoOrganizacional> save(@RequestBody @Valid EspacoOrganizacionalDTO espacoOrganizacionalDTO){
        EspacoOrganizacional espacoOrganizacional = new EspacoOrganizacional();

        BeanUtils.copyProperties(espacoOrganizacionalDTO, espacoOrganizacional);

        EspacoOrganizacional espacoOrganizacionalSalvo = espacoOrganizacionalService.save(espacoOrganizacional);

        for (Localizacao localizacao : espacoOrganizacionalDTO.getLocalizacoes()) {
            localizacao.setIdEspacoOrganizacional(espacoOrganizacionalSalvo);
            localizacaoService.save(localizacao);
        }

        System.out.println(espacoOrganizacionalSalvo);

        return ResponseEntity.status(HttpStatus.CREATED).body(espacoOrganizacional);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id){
        Optional<EspacoOrganizacional> estoque = espacoOrganizacionalService.findById(id);
        if (estoque.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado estoque com o id " + id + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.findByIdLocalizacao(estoque.get()));
    }
}
