package br.sc.senai.almoxarifado.repository;


import br.sc.senai.almoxarifado.model.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByClassificacao(String classificacao);

    List<Item> findByItemDescartavel(Integer itemDescartavel);
}
