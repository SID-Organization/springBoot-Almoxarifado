package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Ocorrencia;
import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
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

    public List<Ocorrencia> findAll() {
        return ocorrenciaRepository.findAll();
    }

    public <S extends Ocorrencia> S save(S entity) {
        return ocorrenciaRepository.save(entity);
    }

    public Optional<Ocorrencia> findById(Integer integer) {
        return ocorrenciaRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return ocorrenciaRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        ocorrenciaRepository.deleteById(integer);
    }

    public List<Ocorrencia> findByMatriculaPessoa(Long matriculaPessoa) {
        return ocorrenciaRepository.findByMatriculaPessoa(matriculaPessoa);
    }

    public List<Ocorrencia> findByReservaItem(ReservaItem reservaItem) {
        return ocorrenciaRepository.findByReservaItem(reservaItem);
    }

}
