package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import br.sc.senai.almoxarifado.repository.ValorPredefinidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValorPredefinidoService {
    @Autowired
    private ValorPredefinidoRepository valorPredefinidoRepository;

    public List<ValorPredefinido> findByCampo(Campo campo) {
        return valorPredefinidoRepository.findByIdCampo(campo);
    }

    public List<ValorPredefinido> findAll() {
        return valorPredefinidoRepository.findAll();
    }

    public <S extends ValorPredefinido> S save(S entity) {
        return valorPredefinidoRepository.save(entity);
    }

    public Optional<ValorPredefinido> findById(Integer integer) {
        return valorPredefinidoRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return valorPredefinidoRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        valorPredefinidoRepository.deleteById(integer);
    }
}

