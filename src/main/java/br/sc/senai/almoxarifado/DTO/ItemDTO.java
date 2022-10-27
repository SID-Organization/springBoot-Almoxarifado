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
    private String nome;
    private String caracteristica;
    private String classificacao;
    private String detalhes;
    @NotNull
    private Integer itemDescartavel;
    private Estoque idEstoque;
    private File fotoIlustrativa;
//    private ArrayList<File> listaDeArquivos;
}
