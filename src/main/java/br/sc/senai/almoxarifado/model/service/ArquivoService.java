package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Arquivo;
import br.sc.senai.almoxarifado.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArquivoService {
    @Autowired
    ArquivoRepository arquivoRepository;

    public List<Arquivo> findAll() {
        return arquivoRepository.findAll();
    }

    public <S extends Arquivo> S save(S entity) {
        return arquivoRepository.save(entity);
    }

    public Optional<Arquivo> findById(Integer integer) {
        return arquivoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return arquivoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        arquivoRepository.deleteById(integer);
    }
}
