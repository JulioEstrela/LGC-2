package bolsa;
import estruturadados.DynamicArray;

public class Carteira {
    private DynamicArray<Ativo> ativos;

    public Carteira(DynamicArray<Ativo> ativos) {
        this.ativos = ativos;
    }
}
