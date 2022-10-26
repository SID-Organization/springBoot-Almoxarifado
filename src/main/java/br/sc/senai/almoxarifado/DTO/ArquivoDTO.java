package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Item;
import lombok.Getter;
import lombok.ToString;

import java.io.File;

@ToString
@Getter
public class ArquivoDTO {
    private String arquivo;
    private Item idItem;
}
