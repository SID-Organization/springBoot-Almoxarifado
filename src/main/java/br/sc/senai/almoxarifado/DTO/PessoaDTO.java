package br.sc.senai.almoxarifado.DTO;

import br.sc.senai.almoxarifado.model.entities.Cargo;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PessoaDTO {
    private Long matricula;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Cargo cargo;
}
