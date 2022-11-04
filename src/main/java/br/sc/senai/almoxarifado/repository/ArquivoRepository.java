package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Arquivo;
import br.sc.senai.almoxarifado.model.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {

    List<Arquivo> findAllByIdItem(Item idItem);

}
