package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaItemRepository extends JpaRepository<ReservaItem, Integer> {
    List<ReservaItem> findByIdReserva(Reserva reserva);
}
