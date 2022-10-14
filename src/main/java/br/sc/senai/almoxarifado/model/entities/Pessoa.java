package br.sc.senai.almoxarifado.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atmosphere.config.service.Get;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_pessoa")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
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
    @Column(length = 1, nullable = false)
    private Integer tipo;
    // 1- Professor
    // 2- Atendente
    // 3- Atendente Jr
    // 4- Admin
}

