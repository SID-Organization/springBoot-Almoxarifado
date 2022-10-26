package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.repository.ReservaItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ReservaItemService {

    @Autowired
    ReservaItemRepository reservaItemRepository;

    public List<ReservaItem> findAll(){
        return reservaItemRepository.findAll();
    }

    public List<ReservaItem> findByIdReserva(Reserva reserva) {
        return reservaItemRepository.findByIdReserva(reserva);
    }

    public <S extends ReservaItem> S save(S entity) {
        return reservaItemRepository.save(entity);
    }

    public Optional<ReservaItem> findById(Integer integer) {
        return reservaItemRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return reservaItemRepository.existsById(integer);
    }

    public void deleteById(Integer integer) {
        reservaItemRepository.deleteById(integer);
    }
}
