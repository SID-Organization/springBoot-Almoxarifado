package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Reserva;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.repository.ReservaItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaItemService {

    @Autowired
    ReservaItemRepository reservaItemRepository;

    public List<ReservaItem> findAll(){
        return reservaItemRepository.findAll();
    }
}
