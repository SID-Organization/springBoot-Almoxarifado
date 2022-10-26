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

    @Id
    @Column(length = 50, nullable = false, unique = true)
    private String matricula;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String sobrenome;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Cargo cargo;
    // Administrador
    // Atendente
    // Assistente
    // Professor
}

