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
    Integer qtdItensReserva;

    @ManyToOne
    @JoinColumn(name = "id_item", nullable = false)
    Item idItem;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    Reserva idReserva;
}
