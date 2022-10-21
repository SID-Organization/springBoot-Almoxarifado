package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.Status;
import br.sc.senai.almoxarifado.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;


    public boolean existsById(Integer id) {
        return reservaRepository.existsById(id);
    }
//
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }
//
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findByStatus(Status status) {
        return reservaRepository.findByStatus(status);
    }

    public void deleteById(Integer id) {
        reservaRepository.deleteById(id);
    }
}
