package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.repository.EspacoOrganizacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EspacoOrganizacionalService {

    @Autowired
    EspacoOrganizacionalRepository espacoOrganizacionalRepository;

    public List<EspacoOrganizacional> findAll() {
        return espacoOrganizacionalRepository.findAll();
    }

    public EspacoOrganizacional save(EspacoOrganizacional espacoOrganizacional) {
        return espacoOrganizacionalRepository.save(espacoOrganizacional);
    }

    public Optional<EspacoOrganizacional> findById(Integer id) {
        return espacoOrganizacionalRepository.findById(id);
    }

    public boolean existsById(Integer integer) {
        return espacoOrganizacionalRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        espacoOrganizacionalRepository.deleteById(integer);
    }
}
