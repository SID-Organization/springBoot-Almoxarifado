package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }
}
