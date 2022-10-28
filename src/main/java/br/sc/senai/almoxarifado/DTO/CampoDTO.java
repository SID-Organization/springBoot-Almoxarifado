package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.ValorPredefinido;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@ToString
public class CampoDTO {
    @NotBlank
    private String nomeCampo;

    @NotNull
    private List<ValorPredefinido> valores;
}
