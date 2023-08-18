public class Investimento {
    private  String nome;
    private float preco;
    private float dividendos;

    public Investimento(String nome, float preco, float dividendos) {
        this.nome = nome;
        this.preco = preco;
        this.dividendos = dividendos;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public float getDividendos() {
        return dividendos;
    }
}
