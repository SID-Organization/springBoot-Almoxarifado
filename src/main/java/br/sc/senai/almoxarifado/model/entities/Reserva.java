package br.sc.senai.almoxarifado.model.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.PastOrPresent;
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

    @Future
    @Column(length = 50, nullable = false)
    private Date dataRetirada;

    @PastOrPresent
    @Column(length = 50, nullable = true)
    private Date dataRetirado;

    @FutureOrPresent
    @Column(length = 50, nullable = false)
    private Date dataDevolucao;

}
