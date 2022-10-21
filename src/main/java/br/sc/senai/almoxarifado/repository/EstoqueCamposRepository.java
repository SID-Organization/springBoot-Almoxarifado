package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueCamposRepository extends JpaRepository<EstoqueCampos, Integer> {

}
