package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Localizacao;
import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EspacoOrganizacionalDTO {
    private String nomeEspacoOrganizacional;
    private List<Localizacao> localizacoes;
}
