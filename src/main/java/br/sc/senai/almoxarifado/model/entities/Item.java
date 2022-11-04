package br.sc.senai.almoxarifado.model.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Table(name = "itens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long idItem;

    @Column(length = 45, nullable = false)
    private String nomeItem;

    @Column(length = 50)
    private String caracteristicaItem;

    @Column(length = 50, nullable = false)
    private String classificacaoItem;

    @Column(length = 45)
    private String detalhesItem;

    @Column(nullable = false)
    private Boolean itemDescartavel;

    @Column(nullable = false)
    private Integer quantidadeItem;

    @Column
    @Lob
    private byte[] fotoIlustrativa;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "posicaoEstoque", referencedColumnName = "idEspacoOrganizacional", nullable = false)
    private EspacoOrganizacional idEspacoOrganizacional;
}
