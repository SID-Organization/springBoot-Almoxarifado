package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "arquivos")
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idArquivo;

    @NonNull
    private String nomeArquivo;

    @NonNull
    private String tipoArquivo;

    @NonNull
    @Lob
    private byte[] arquivo;

    @ManyToOne
    @JoinColumn(name = "idItem")
    private Item idItem;
}
