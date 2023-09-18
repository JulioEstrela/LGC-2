package bolsa;

public class Corretora {
    private String nome;
    private double taxa;

    public Corretora(String nome, double taxa) {
        this.nome = nome;
        this.taxa = taxa;
    }

    public double getTaxa(Ativo ativo, int quantidade) {
        taxa = taxa/100 * ativo.getCotacao() * quantidade;
        return taxa;
    }

    @Override
    public String toString() {
        return "Corretora{" +
                "nome='" + nome + '\'' +
                ", taxa=" + taxa +
                '}';
    }
}
