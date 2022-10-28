package br.sc.senai.almoxarifado.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "valores_campos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class ValorPredefinido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idValorPredefinido;

    @Column(nullable = false)
    private String valorPredefinido;

    @ManyToOne
    @JoinColumn(name = "id_campo", nullable = false)
    private Campo idCampo;
}
