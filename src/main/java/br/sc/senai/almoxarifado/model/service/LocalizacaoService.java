package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.model.entities.Localizacao;
import br.sc.senai.almoxarifado.repository.LocalizacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public List<Localizacao> findByIdLocalizacao(EspacoOrganizacional idEspacoOrganizacional) {
        return localizacaoRepository.findByIdLocalizacao(idEspacoOrganizacional);
    }

    public List<Localizacao> findAll() {
        return localizacaoRepository.findAll();
    }

    public <S extends Localizacao> S save(S entity) {
        return localizacaoRepository.save(entity);
    }

    public Optional<Localizacao> findById(Integer integer) {
        return localizacaoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return localizacaoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        localizacaoRepository.deleteById(integer);
    }

}
