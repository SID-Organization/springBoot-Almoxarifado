package br.sc.senai.almoxarifado.model.entities;

import lombok.*;
import org.atmosphere.config.service.Get;

import javax.persistence.*;

@Entity
@Table(name = "pessoas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Pessoa {

    @NonNull
    @Id
    @Column(length = 50, nullable = false, unique = true)
    private Long matricula;

    @NonNull
    @Column(length = 50, nullable = false)
    private String nome;

    @NonNull
    @Column(length = 50, nullable = false)
    private String sobrenome;

    @NonNull
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @NonNull
    @Column(length = 50, nullable = false)
    private String senha;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;
    // Administrador
    // Atendente
    // Assistente
    // Professor
}

