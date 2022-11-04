package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.EspacoOrganizacional;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.ArrayList;

@ToString
@Getter
public class ItemDTO {
    @NotBlank
    private String nomeItem;
    private String caracteristicaItem;
    private String classificacaoItem;
    private String detalhesItem;
    private Integer quantidadeItem;
    private Boolean itemDescartavel;
    private EspacoOrganizacional idEspacoOrganizacional;
}
