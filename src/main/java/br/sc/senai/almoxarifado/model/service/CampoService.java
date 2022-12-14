package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.repository.CampoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CampoService {

    @Autowired
    CampoRepository campoRepository;

    public List<Campo> findAll() {
        return campoRepository.findAll();
    }

    public Campo save(Campo campo) {
        return campoRepository.save(campo);
    }

    public Optional<Campo> findById(Integer integer) {
        return campoRepository.findById(integer);
    }

    @Query(value = "SELECT * FROM campos INNER JOIN localizacao ON id_espaco_organizacional = ?1", nativeQuery = true)
    public List<Campo> findAllByIdEspacoOrganizacional(Integer idEspacoOrganizacional) {
        return campoRepository.findAllByIdEspacoOrganizacional(idEspacoOrganizacional);
    }
}
