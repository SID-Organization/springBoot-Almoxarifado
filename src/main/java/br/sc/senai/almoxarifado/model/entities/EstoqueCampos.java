package br.sc.senai.almoxarifado.model.entities;

import lombok.*;
import org.atmosphere.config.service.Get;

import javax.persistence.*;

@Entity
@Table(name = "estoques_has_campos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class EstoqueCampos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idEstoqueCampos;

    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Estoque idEstoque;

    @ManyToOne
    @JoinColumn(nullable = false, unique = true)
    private Campo idCampo;

    @Column(nullable = false)
    private String valorCampo;
}
