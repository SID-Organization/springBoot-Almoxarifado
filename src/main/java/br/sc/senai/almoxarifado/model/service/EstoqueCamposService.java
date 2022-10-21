package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import br.sc.senai.almoxarifado.repository.EstoqueCamposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueCamposService {

    @Autowired
    private EstoqueCamposRepository estoqueCamposRepository;

    public List<EstoqueCampos> findAll() {
        return estoqueCamposRepository.findAll();
    }
}
