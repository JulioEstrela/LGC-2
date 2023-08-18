public class Acoes extends Investimento{

    public Acoes(String nome, float preco, float dividendos) {
        super(nome, preco, dividendos);
    }

    public Acoes(String nome, float preco) {
        super(nome, preco, 0);
    }
}
