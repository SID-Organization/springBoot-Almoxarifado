package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import br.sc.senai.almoxarifado.model.entities.Status;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.FutureOrPresent;
import java.util.Date;
import java.util.List;

@ToString
@Getter
public class ReservaDTO {

    private Pessoa matricula;
    @FutureOrPresent
    private Date dataRetirada;
    private Date dataRetirado;
    private Date dataDevolucao;
    private List<ReservaItem> reservaItem;

}
