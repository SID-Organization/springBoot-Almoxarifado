package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Arquivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {

}
