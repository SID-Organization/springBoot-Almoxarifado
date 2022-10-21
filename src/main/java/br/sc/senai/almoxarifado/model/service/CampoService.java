package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.repository.CampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampoService {

    @Autowired
    CampoRepository campoRepository;

    public List<Campo> findAll() {
        return campoRepository.findAll();
    }
}
