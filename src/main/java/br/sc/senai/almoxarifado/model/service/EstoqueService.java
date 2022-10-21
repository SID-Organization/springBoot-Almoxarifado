package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }
}
