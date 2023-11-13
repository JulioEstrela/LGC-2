package com.example.bolsadevalores.model;
import com.example.bolsadevalores.estruturadados.DynamicArray;

public abstract class Carteira {
    private DynamicArray<Ativo> ativos;

    public Carteira(DynamicArray<Ativo> ativos) {
        this.ativos = ativos;
    }

    public DynamicArray<Ativo> getAtivos() {
        return ativos;
    }
}
