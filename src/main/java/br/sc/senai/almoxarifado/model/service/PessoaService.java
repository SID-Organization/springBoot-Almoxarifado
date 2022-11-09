package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Cargo;
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

    public Optional<Pessoa> findByMatricula(String matricula) {
        return pessoaRepository.findByMatricula(matricula);
    }

    public boolean existsById(Long aLong) {
        return pessoaRepository.existsById(aLong);
    }

    public boolean existsByMatricula(String matricula) {
        return pessoaRepository.existsByMatricula(matricula);
    }

    public void deleteById(Long aLong) {
        pessoaRepository.deleteById(aLong);
    }

    public void deleteByMatricula(String matricula) {
        pessoaRepository.deleteByMatricula(matricula);
    }

    public void delete(Pessoa entity) {
        pessoaRepository.delete(entity);
    }

    public <S extends Pessoa> Page<S> findAll(Example<S> example, Pageable pageable) {
        return pessoaRepository.findAll(example, pageable);
    }

    public List<Pessoa> findAllByCargo(Cargo cargo) {
        return pessoaRepository.findAllByCargo(cargo);
    }
}
