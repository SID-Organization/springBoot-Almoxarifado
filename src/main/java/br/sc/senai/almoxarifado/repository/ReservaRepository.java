package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

}


