package br.sc.senai.almoxarifado.DTO;

import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class PessoaDTO {
    private String matricula;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
    private Integer tipo;
}
