package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.entities.Status;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.FutureOrPresent;
import java.util.Date;

@ToString
@Getter
public class ReservaDTO {

    private Pessoa matricula;
    private Status status;
    @FutureOrPresent
    private Date dataRetirada;
    private Date dataRetirado;
    private Date dataDevolucao;

}
