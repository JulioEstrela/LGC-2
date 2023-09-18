package bolsa;
import estruturadados.StaticArray;

public class Carteira {
    private StaticArray<Ativo> ativos;

    public Carteira(StaticArray<Ativo> ativos) {
        this.ativos = ativos;
    }
}
