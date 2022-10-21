package br.sc.senai.almoxarifado.model.entities;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "arquivos")
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idArquivo;

    @Column(nullable = false)
    private File arquivo;
}
