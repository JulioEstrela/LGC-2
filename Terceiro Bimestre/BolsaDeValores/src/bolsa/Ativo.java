package bolsa;

public abstract class Ativo {
    private String nome;
    private String sigla;
    private double cotacao;
    private double dividendos;
    private int lotePadrao;

    public Ativo(String nome, String sigla, double cotacao, int lotePadrao, double dividendos) {
        this.nome = nome;
        this.sigla = sigla;
        this.cotacao = cotacao;
        this.dividendos = dividendos;
        this.lotePadrao = lotePadrao;
    }

    public double getCotacao() {
        return cotacao;
    }

    @Override
    public String toString() {
        return "Ativo{" +
                "nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", cotacao=" + cotacao +
                ", dividendos=" + dividendos +
                ", lotePadrao=" + lotePadrao +
                '}';
    }
}
