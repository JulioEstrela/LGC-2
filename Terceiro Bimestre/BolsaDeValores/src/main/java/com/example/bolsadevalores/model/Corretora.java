package com.example.bolsadevalores.model;

public class Corretora {
    private String nome;
    private double taxaInicial;
    private double taxa;

    public Corretora(String nome, double taxaInicial) {
        this.nome = nome;
        this.taxaInicial = taxaInicial;
        this.taxa = this.taxaInicial;
    }

    public double getTaxa(Ativo ativo, int quantidade) {
        taxa = taxaInicial/100 * ativo.getCotacao() * quantidade;
        return taxa;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return nome;
    }
}
