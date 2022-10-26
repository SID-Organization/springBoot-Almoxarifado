package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.Estoque;
import lombok.Getter;

@Getter
public class EstoqueCampoDTO {
    private Estoque idEstoque;
    private Campo idCampo;
    private String valorCampo;
}
