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

    @OneToMany
    @JoinColumn(name = "idEstoqueCampos")
    private List<EstoqueCampos> listaCampos;

    /*
    {
        "idEstoque": 1,
        "qtdItemEstoque": 10,
        "listaCampos": [
            {
                "idCampo": 1,
                "valorCampo": 1
            },
            {
                "idCampo": 2,
                "valorCampo": 2
            }
        ]
    }
     */
}
