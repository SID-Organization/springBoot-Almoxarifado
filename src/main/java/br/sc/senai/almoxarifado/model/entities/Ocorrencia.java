package br.sc.senai.almoxarifado.model.entities;

import javax.persistence.*;

@Entity
@Table(name = "ocorrencias")
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Long idOcorrencia;

    @Column(nullable = false)
    private String descricaoOcorrencia;

//    @JoinColumn(name = "idReservaItens_idItem")
//    //?????
//
//    @JoinColumn(name = "idReservaItens_idReserva")
//    //?????
}
