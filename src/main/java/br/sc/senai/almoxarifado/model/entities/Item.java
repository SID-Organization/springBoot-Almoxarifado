package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "itens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @Column
    private File fotoIlustrativa;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "posicaoEstoque", referencedColumnName = "idEstoque", nullable = false)
    private Estoque estoque;

    @Column(nullable = false)
    private List<File> listaDeArquivos;
}
