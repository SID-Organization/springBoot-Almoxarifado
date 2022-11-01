package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class OcorrenciaDTO {
    private String descricao;
    private ReservaItem reservaItem_IdReserva;
}
