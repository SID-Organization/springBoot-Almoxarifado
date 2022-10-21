package br.sc.senai.almoxarifado.model.service;

import br.sc.senai.almoxarifado.model.entities.Item;
import br.sc.senai.almoxarifado.repository.ItemRepository;

import java.util.List;
import java.util.Optional;

public class ItemService {
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
        return itemRepository.findByClassificacao(classificacao);
    }

    public List<Item> findByItemDescartavel(Integer itemDescartavel) {
        return itemRepository.findByItemDescartavel(itemDescartavel);
    }

    public Optional<Item> findById(Long aLong) {
        return itemRepository.findById(aLong);
    }

    public void deleteById(Long isbn) {
        itemRepository.deleteById(isbn);
    }

}
