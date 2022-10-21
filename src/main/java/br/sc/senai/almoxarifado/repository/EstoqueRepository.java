package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Integer> {
}
