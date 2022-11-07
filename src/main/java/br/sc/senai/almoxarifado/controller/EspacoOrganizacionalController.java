package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.EspacoOrganizacionalDTO;
import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.model.entities.Localizacao;
import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.service.LocalizacaoService;
import br.sc.senai.almoxarifado.model.service.EspacoOrganizacionalService;
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
@RequestMapping("/almoxarifado/espaco-organizacional")
public class EspacoOrganizacionalController {

    @Autowired
    EspacoOrganizacionalService espacoOrganizacionalService;

    @Autowired
    LocalizacaoService localizacaoService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<EspacoOrganizacional>> findAll() {

        List<EspacoOrganizacional> listaEspacoOrganizacionais = espacoOrganizacionalService.findAll();

        if (listaEspacoOrganizacionais.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(listaEspacoOrganizacionais);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<EspacoOrganizacional> save(@RequestBody @Valid EspacoOrganizacionalDTO espacoOrganizacionalDTO) {
        EspacoOrganizacional espacoOrganizacional = new EspacoOrganizacional();

        BeanUtils.copyProperties(espacoOrganizacionalDTO, espacoOrganizacional);
        EspacoOrganizacional espacoOrganizacionalSalvo = espacoOrganizacionalService.save(espacoOrganizacional);

        for (Localizacao localizacao : espacoOrganizacionalDTO.getLocalizacoes()) {
            localizacao.setIdEspacoOrganizacional(espacoOrganizacionalSalvo);
            localizacaoService.save(localizacao);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(espacoOrganizacional);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/id/{id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "id") Integer id) {
        Optional<EspacoOrganizacional> espacoOrganizacional = espacoOrganizacionalService.findById(id);
        System.out.println("passou aqui");
        if (espacoOrganizacional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi encontrado reserva com o id " + id + ".");
        }
        return ResponseEntity.status(HttpStatus.OK).body(localizacaoService.findByEspacoOrganizacional(espacoOrganizacional.get()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/id/{id}")
    public ResponseEntity<EspacoOrganizacional> update(@PathVariable(value = "id") Integer id, @RequestBody EspacoOrganizacionalDTO espacoOrganizacionalDTO) {
        Optional<EspacoOrganizacional> espacoOrganizacional = espacoOrganizacionalService.findById(id);
        if (espacoOrganizacional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
        BeanUtils.copyProperties(espacoOrganizacionalDTO, espacoOrganizacional.get());
        espacoOrganizacionalService.save(espacoOrganizacional.get());
        return ResponseEntity.status(HttpStatus.OK).body(espacoOrganizacional.get());
    }
}
