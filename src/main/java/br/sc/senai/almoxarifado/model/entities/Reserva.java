package br.sc.senai.almoxarifado.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "matricula_pessoa", nullable = false)
    private Pessoa matricula;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Column(length = 50, nullable = false)
    private Date dataRetirada;

    @Column(length = 50, nullable = true)
    private Date dataRetirado;

    @Column(length = 50, nullable = false)
    private Date dataDevolucao;

}
