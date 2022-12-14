package br.sc.senai.almoxarifado.model.utils;

import br.sc.senai.almoxarifado.DTO.ItemDTO;
import br.sc.senai.almoxarifado.model.entities.Item;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ItemUtil {

    private ObjectMapper mapper = new ObjectMapper();

    public Item convertJsonToModel(String itemJson) {
        try {
            ItemDTO itemDto = convertToDto(itemJson);
            return convertDtoToModel(itemDto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter o itemJson para objeto Item");
        }
    }

    private Item convertDtoToModel(ItemDTO itemDto) {
        return this.mapper.convertValue(itemDto, Item.class);
    }

    public ItemDTO convertToDto(String  itemJson) {
        try{
            return this.mapper.readValue(itemJson, ItemDTO.class);
        } catch (Exception e){
            throw  new RuntimeException(e);
        }
    }
}
