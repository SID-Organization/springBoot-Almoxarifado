package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "campos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Campo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer idCampo;

    @NonNull
    @Column(nullable = false, unique = true)
    private String nomeCampo;
}
