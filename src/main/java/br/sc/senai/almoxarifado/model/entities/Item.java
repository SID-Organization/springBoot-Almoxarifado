package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "itens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

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

    @Column
    private File fotoIlustrativa;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "posicaoEstoque", referencedColumnName = "idEspacoOrganizacional", nullable = false)
    private EspacoOrganizacional idEspacoOrganizacional;
}
