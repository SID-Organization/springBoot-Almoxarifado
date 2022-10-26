package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Estoque;
import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import br.sc.senai.almoxarifado.repository.EstoqueCamposRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueCamposService {

    @Autowired
    private EstoqueCamposRepository estoqueCamposRepository;

    public List<EstoqueCampos> findByIdEstoque(Estoque idEstoque) {
        return estoqueCamposRepository.findByIdEstoque(idEstoque);
    }

    public List<EstoqueCampos> findAll() {
        return estoqueCamposRepository.findAll();
    }

    public <S extends EstoqueCampos> S save(S entity) {
        return estoqueCamposRepository.save(entity);
    }

    public Optional<EstoqueCampos> findById(Integer integer) {
        return estoqueCamposRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return estoqueCamposRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        estoqueCamposRepository.deleteById(integer);
    }

}
