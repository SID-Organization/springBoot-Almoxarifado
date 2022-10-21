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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 40, nullable = false, unique = true)
    private Integer idReserva;

    @ManyToOne
    @JoinColumn(name = "matriculaPessoa", nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "arquivos")
    private List<Arquivo> arquivosExtras;

    @ManyToOne
    @JoinColumn(name = "pessoa_cpf", nullable = false)
    private Pessoa pessoa;


}
