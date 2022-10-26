package br.sc.senai.almoxarifado.DTO;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;

@ToString
@Getter
public class ItemDTO {
    private String nomeItem;
    private String caracteristicaItem;
    private String classificacaoItem;
    private String detalhesItem;
    private Integer itemDescartavel;
    private Integer idPosicaoEstoque;
    private ArrayList<File> listaDeArquivos;
}
