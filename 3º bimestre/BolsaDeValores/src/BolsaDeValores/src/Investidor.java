import java.util.ArrayList;
import java.util.List;

public class Investidor {
    private String nome;
    private List<Investimento> investimentos;
    private float dinheiro;

    public Investidor(String nome, float dinheiro) {
        this.nome = nome;
        this.investimentos = new ArrayList<>();
        this.dinheiro = dinheiro;
    }


}
