package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Item;
import br.sc.senai.almoxarifado.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    ItemRepository itemRepository;

    public boolean existsById(Long id) {
        return itemRepository.existsById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }


    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public List<Item> findByClassificacao(String classificacao) {
        return itemRepository.findByClassificacaoItem(classificacao);
    }

    public List<Item> findByItemDescartavel(Integer itemDescartavel) {
        return itemRepository.findByItemDescartavel(itemDescartavel);
    }

    public Optional<Item> findById(Long id) {
        return itemRepository.findById(id);
    }

    public void deleteById(Long id) {
        itemRepository.deleteById(id);
    }

}
