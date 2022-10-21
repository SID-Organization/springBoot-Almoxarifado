package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reservas_has_itens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class ReservaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    Integer idReservaItem;

    @Column
    Integer qtdReserva;

    @ManyToOne
    @JoinColumn(name = "id_item")
    Integer idItem;

    @ManyToOne
    @JoinColumn(name = "id_reserva")
    Integer idReserva;
}
