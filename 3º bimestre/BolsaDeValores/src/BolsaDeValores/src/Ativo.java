public abstract class Ativo {
    private String nome;
    private String codigo;
    private double cotacao;
    private double dividendos;
    private int lotePadrao;

    public Ativo(String nome, String codigo, double cotacao, int lotePadrao, double dividendos) {
        this.nome = nome;
        this.codigo = codigo;
        this.cotacao = cotacao;
        this.dividendos = dividendos;
        this.lotePadrao = lotePadrao;
    }
}
