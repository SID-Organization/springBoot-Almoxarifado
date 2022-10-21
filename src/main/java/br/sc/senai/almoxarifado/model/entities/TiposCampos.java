package br.sc.senai.almoxarifado.model.entities;


public enum TiposCampos {
    TEXTO("Texto"),
    NUMERO("Número");

    private String nome;

    TiposCampos (String nome){
        this.nome = nome;
    }

}
