package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Status;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@ToString
@Getter
public class ReservaDTO {

    private String matricula;
    private Status status;
    private Date dataRetirada;
    private Date dataRetirado;
    private Date dataDevolucao;

}
