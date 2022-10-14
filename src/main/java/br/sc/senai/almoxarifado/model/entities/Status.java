package br.sc.senai.almoxarifado.model.entities;

public enum Status {
    RETIRAR("Retirar"),
    ATIVO("Ativo"),
    PENDENTE("Pendente"),
    FINALIZADO("Finalizado"),
    CANCELADO("Cancelado"),
    PARCIALMENTE_DEVOLVIDO("Parcialmente Devolvido");

    String nome;
    Status(String nome){
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
