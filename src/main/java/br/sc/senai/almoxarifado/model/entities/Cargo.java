package br.sc.senai.almoxarifado.model.entities;

public enum Cargo {
    ADMINISTRADOR("Administrador"),
    ATENDENTE("Atendente"),
    ASSISTENTE("Assistente"),
    PROFESSOR("Professor"),
    PENDENTE("Pendente");


    String nome;
    Cargo(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
