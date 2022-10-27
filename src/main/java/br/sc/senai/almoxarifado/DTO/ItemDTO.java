package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Estoque;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.ArrayList;

@ToString
@Getter
public class ItemDTO {
    @NotBlank
    private String nomeItem;
    private String caracteristicaItem;
    private String classificacaoItem;
    private String detalhesItem;
    @NotNull
    private boolean itemDescartavel;
    private Estoque idEstoque;
    private File fotoIlustrativa;
//    private ArrayList<File> listaDeArquivos;
}
