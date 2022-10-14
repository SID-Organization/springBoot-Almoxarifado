package br.sc.senai.almoxarifado.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;

@Entity
@Table(name = "tb_item")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Item {

    @Id
    @Column(nullable = false, unique = true)
    private Integer idItem;

    @Column(length = 45, nullable = false)
    private String nomeItem;

    @Column(length = 50)
    private String caracteristicaItem;

    @Column(length = 50, nullable = false)
    private String classificacaoItem;

    @Column(length = 45)
    private String detalhesItem;

    @Column(length = 1, nullable = false)
    private Integer itemDescartavel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posicaoEstoque", referencedColumnName = "idEstoque")
    @Column(nullable = false)
    private Integer idPosicaoEstoque;

    @Column(nullable = false)
    private ArrayList<File> listaDeArquivos;
}
