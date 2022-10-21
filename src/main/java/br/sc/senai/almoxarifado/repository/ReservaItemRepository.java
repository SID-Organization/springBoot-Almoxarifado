package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaItemRepository extends JpaRepository<ReservaItem, Integer> {

}
