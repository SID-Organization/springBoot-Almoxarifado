package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Campo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampoRepository extends JpaRepository<Campo, Integer> {

    @Query(value = "SELECT * FROM campos INNER JOIN localizacao ON id_espaco_organizacional = ?1", nativeQuery = true)
    List<Campo> findAllByIdEspacoOrganizacional(Integer idEspacoOrganizacional);

}
