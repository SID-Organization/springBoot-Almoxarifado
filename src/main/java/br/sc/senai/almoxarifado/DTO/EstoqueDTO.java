package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstoqueDTO {
    private Integer qtdItemEstoque;
    private List<EstoqueCampos> estoqueCampos;
}
