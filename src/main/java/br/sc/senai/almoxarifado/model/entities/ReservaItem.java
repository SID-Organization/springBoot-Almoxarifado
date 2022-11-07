package br.sc.senai.almoxarifado.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "reservas_has_itens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class ReservaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Integer idReservaItem;

    @NonNull
    @Column(nullable = false)
    Integer qtdItensReserva;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_item", nullable = false)
    Item idItem;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_reserva", nullable = false)
    Reserva idReserva;

    @Column
    Integer devolvido;
}
