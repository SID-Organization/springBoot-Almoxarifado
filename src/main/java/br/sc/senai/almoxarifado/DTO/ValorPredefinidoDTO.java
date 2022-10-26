package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Campo;
import lombok.Getter;

@Getter
public class ValorPredefinidoDTO {
    private String valorPredefinido;
    private Campo idCampo;
}
