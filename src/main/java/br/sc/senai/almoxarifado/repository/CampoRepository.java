package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Integer> {
}
