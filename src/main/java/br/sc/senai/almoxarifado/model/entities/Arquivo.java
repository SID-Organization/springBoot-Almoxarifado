package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "arquivos")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer idArquivo;

    @NonNull
    @Column(nullable = false)
    private String arquivo;

    @NonNull
    @ManyToOne
    @JoinColumn
    private Item idItem;
}
