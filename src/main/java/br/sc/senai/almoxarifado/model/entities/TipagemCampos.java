package br.sc.senai.almoxarifado.model.entities;


public enum TipagemCampos {
    TEXTO("Texto"),
    NUMERO("Número");

    private String nome;

    TipagemCampos(String nome){
        this.nome = nome;
    }

}
