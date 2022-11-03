package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "espaco_organizacional")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class EspacoOrganizacional {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idEspacoOrganizacional;

    @NonNull
    @Column(nullable = false)
    private Integer qtdItemEspacoOrganizacional;

    @NonNull
    @Column(nullable = false)
    private String nomeEspacoOrganizacional;

}
