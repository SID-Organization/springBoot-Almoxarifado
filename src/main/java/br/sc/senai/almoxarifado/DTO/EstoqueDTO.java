package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.EstoqueCampos;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter @Setter
public class EstoqueDTO {
    private Integer qtdItemEstoque;
    private List<EstoqueCampos> estoqueCampos;
}
