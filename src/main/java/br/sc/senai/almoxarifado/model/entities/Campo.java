package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "campos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Campo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idCampo;

    @Column(nullable = false, unique = true)
    private String nomeCampo;

    @OneToMany
    @JoinColumn(nullable = false)
    private List<ValorPredefinido> valoresPredefinidos;
}
