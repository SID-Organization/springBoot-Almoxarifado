package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Campo;
import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import lombok.Getter;

@Getter
public class LocalizacaoDTO {
    private EspacoOrganizacional idEspacoOrganizacional;
    private Campo idCampo;
    private String valorCampo;
}
