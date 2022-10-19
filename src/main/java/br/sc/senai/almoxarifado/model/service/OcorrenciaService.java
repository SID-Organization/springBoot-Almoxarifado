package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Ocorrencia;
import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.repository.OcorrenciaRepository;
import br.sc.senai.almoxarifado.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciaService {
    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    public List<Ocorrencia> findByPessoa(Pessoa pessoa) {
        return ocorrenciaRepository.findByPessoa(pessoa);
    }

    public List<Ocorrencia> findByIdItem(Long idItem) {
        return ocorrenciaRepository.findByIdItem(idItem);
    }

    public List<Ocorrencia> findByIdReserva(Long idReserva) {
        return ocorrenciaRepository.findByIdReserva(idReserva);
    }

    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    public List<Ocorrencia> findAllById(Iterable<Long> longs) {
        return ocorrenciaRepository.findAllById(longs);
    }

    public <S extends Ocorrencia> S save(S entity) {
        return ocorrenciaRepository.save(entity);
    }

    public Optional<Ocorrencia> findById(Long aLong) {
        return ocorrenciaRepository.findById(aLong);
    }

    public boolean existsById(Long aLong) {
        return ocorrenciaRepository.existsById(aLong);
    }

    public void deleteById(Long aLong) {
        ocorrenciaRepository.deleteById(aLong);
    }
}
