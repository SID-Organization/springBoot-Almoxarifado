package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacoOrganizacionalRepository extends JpaRepository<EspacoOrganizacional, Integer> {

}
