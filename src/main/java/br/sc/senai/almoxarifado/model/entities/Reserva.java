package br.sc.senai.almoxarifado.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservas")
@Getter @Setter
@AllArgsConstructor
public class Reserva
{
    @Id
    @Column(length = 40, nullable = false, unique = true)
    private Integer idReserva;

    @Column(length = 50, nullable = false, unique = true)
    private String matricula;

    @Enumerated(EnumType.STRING)
    @Column(length = 2, nullable = false)
    private Status status;

    @Column(length = 50, nullable = false)
    private Date dataRetirada;

    @Column(length = 50, nullable = false)
    private Date dataRetirado;

    @Column(length = 50, nullable = false)
    private Date dataDevolucao;

}
