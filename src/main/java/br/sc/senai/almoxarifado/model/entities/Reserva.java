package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "reservas")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Reserva
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 40, nullable = false, unique = true)
    private Integer idReserva;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "matricula_pessoa", nullable = false)
    private Pessoa matricula;

    @NonNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @NonNull
    @Column(length = 50, nullable = false)
    private Date dataRetirada;

    @Column(length = 50, nullable = true)
    private Date dataRetirado;

    @NonNull
    @Column(length = 50, nullable = false)
    private Date dataDevolucao;
//
//    @OneToMany(mappedBy = "idReserva",fetch = FetchType.LAZY)
//    private List<ReservaItem> reservaItem;

}
