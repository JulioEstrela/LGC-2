import java.util.ArrayList;
import java.util.List;

public class Investidor {
    String nome;
    double dinheiroDisponivel;
    List<Investimento> investimentos = new ArrayList<Investimento>();

    public Investidor(String nome, double dinheiroDisponivel) {
        this.nome = nome;
        this.dinheiroDisponivel = dinheiroDisponivel;
    }

    public void comprar(Investimento investimento, int quantidade){
        if(investimento.getPreco() * quantidade <= dinheiroDisponivel) {
            dinheiroDisponivel -= investimento.getPreco() * quantidade;
            for (int i = 0; i < quantidade; i++) {
                investimentos.add(investimento);
            }
        }
    }

    int quantidadeDisponivel = 0;
    public void vender(Investimento investimento, int quantidade){
        for (int i = 0; i < investimentos.size(); i++) {
            if(investimentos.get(i) == investimento)
                quantidadeDisponivel++;

            if(quantidadeDisponivel == quantidade)
                break;
        }



        dinheiroDisponivel += investimento.getPreco() * quantidade;
    }

}
