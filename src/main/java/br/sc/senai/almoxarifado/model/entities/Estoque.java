package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "estoques")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Estoque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idEstoque;

    @Column(nullable = false)
    private Integer qtdItemEstoque;

    @ManyToMany
    @JoinTable(
            name = "estoques_has_campos",
            joinColumns = @JoinColumn(name = "id_estoque", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "id_campo", nullable = false)
    )
    private List<Campo> listaCampos;
}
