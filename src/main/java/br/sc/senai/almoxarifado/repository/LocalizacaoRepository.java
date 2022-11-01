package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import br.sc.senai.almoxarifado.model.entities.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer> {
    List<Localizacao> findByIdEspacoOrganizacional(EspacoOrganizacional idEspacoOrganizacional);
}
