package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;

@Entity
@Table(name = "itens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Item {

    @Id
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nome;

    @Column(length = 50)
    private String caracteristica;

    @Column(length = 50, nullable = false)
    private String classificacao;

    @Column(length = 45)
    private String detalhes;

    @Column(length = 1, nullable = false)
    private Integer itemDescartavel;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "posicaoEstoque", referencedColumnName = "idEstoque")
    @Column(nullable = false)
    private Integer idPosicaoEstoque;

    @Column(nullable = false)
    private ArrayList<File> listaDeArquivos;
}