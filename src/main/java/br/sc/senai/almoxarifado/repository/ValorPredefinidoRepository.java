package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ValorPredefinidoRepository extends JpaRepository<ValorPredefinido, Integer> {
    List<ValorPredefinido> findByIdCampo(Campo campo);
}
