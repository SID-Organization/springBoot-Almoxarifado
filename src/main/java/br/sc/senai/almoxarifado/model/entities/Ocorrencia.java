package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "ocorrencias")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "reservaItem_id", nullable = false)
    private ReservaItem reservaItem;

    @ManyToOne
    @JoinColumn(name = "reservaReserva_id", nullable = false)
    private ReservaItem reservaReserva;
}
