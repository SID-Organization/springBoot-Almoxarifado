package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {

    @Autowired
    EstoqueRepository estoqueRepository;

    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    public Estoque save(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public Optional<Estoque> findById(Integer integer) {
        return estoqueRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return estoqueRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        estoqueRepository.deleteById(integer);
    }
}
