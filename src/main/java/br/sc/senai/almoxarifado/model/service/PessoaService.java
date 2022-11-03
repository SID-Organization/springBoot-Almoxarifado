package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public List<Pessoa> findAll(Sort sort) {
        return pessoaRepository.findAll(sort);
    }

    public List<Pessoa> findAllById(Iterable<Long> longs) {
        return pessoaRepository.findAllById(longs);
    }

    public <S extends Pessoa> List<S> findAll(Example<S> example) {
        return pessoaRepository.findAll(example);
    }

    public <S extends Pessoa> S save(S entity) {
        return pessoaRepository.save(entity);
    }

    public Optional<Pessoa> findById(Long matricula) {
        return pessoaRepository.findById(matricula);
    }

    public boolean existsById(Long matricula) {
        return pessoaRepository.existsById(matricula);
    }

    public void deleteById(Long aLong) {
        pessoaRepository.deleteById(aLong);
    }

    public <S extends Pessoa> Page<S> findAll(Example<S> example, Pageable pageable) {
        return pessoaRepository.findAll(example, pageable);
    }
}
