package br.sc.senai.almoxarifado.controller;

import br.sc.senai.almoxarifado.DTO.CampoDTO;
import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import br.sc.senai.almoxarifado.model.service.CampoService;
import br.sc.senai.almoxarifado.model.service.EspacoOrganizacionalService;
import br.sc.senai.almoxarifado.model.service.ValorPredefinidoService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/almoxarifado/campos")
public class CampoController {

    @Autowired
    CampoService campoService;

    @Autowired
    ValorPredefinidoService valorPredefinidoService;

    @Autowired
    EspacoOrganizacionalService espacoOrganizacionalService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity<List<Campo>> findAll() {
        List listaCamposValores = new ArrayList();
        for (Campo campo : campoService.findAll()) {
            listaCamposValores.add(campo);
            listaCamposValores.add(valorPredefinidoService.findByCampo(campo));
        }
        return ResponseEntity.ok(listaCamposValores);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Integer id) {

        Optional<Campo> campo = campoService.findById(id);

        if (campo.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(valorPredefinidoService.findByCampo(campo.get()));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/espaco-organizacional/{id}")
    public ResponseEntity<List<Campo>> findAllByEspacoOrganizacional(@PathVariable Integer id) {
        return ResponseEntity.ok(campoService.findAllByIdEspacoOrganizacional(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<Object> save(@RequestBody @Valid List<CampoDTO> campoDTO) {
        List<Campo> camposCadastrados = new ArrayList<>();

        for (CampoDTO campo : campoDTO) {
            Campo campoEntity = new Campo();
            BeanUtils.copyProperties(campo, campoEntity);
            Campo campoSalvo = campoService.save(campoEntity);

            for (ValorPredefinido valorPredefinido : campo.getValores()) {
                valorPredefinido.setIdCampo(campoSalvo);
                valorPredefinidoService.save(valorPredefinido);
            }

            camposCadastrados.add(campoSalvo);
        }

        return ResponseEntity.ok(camposCadastrados);
    }

    @CrossOrigin(origins = "http://localhost:3000")
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
