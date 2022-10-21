package br.sc.senai.almoxarifado.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "valor_predefinido")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ValorPredefinido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idValorPredefinido;

    @Column(nullable = false)
    private String valorPredefinido;
}
