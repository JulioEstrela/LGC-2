package bolsa;

import estruturadados.DynamicArray;

public class Investidor {
    private String nome;
    private DynamicArray<Ativo> ativos;
    private double dinheiro;

    public Investidor(String nome, double dinheiro) {
        this.nome = nome;
        this.ativos = new DynamicArray<>();
        this.dinheiro = dinheiro;
    }

    public void addDinheiro(double dinheiro){
        this.dinheiro += dinheiro;
    }


    public void comprar(Ativo ativo, Corretora corretora, int quantidade){
        if(quantidade <= 0)
            throw new RuntimeException("Quantidade de ativos deve ser maior que zero");

        double quantidadeNecessaria = ativo.getCotacao() * quantidade + corretora.getTaxa(ativo, quantidade);
        if(quantidadeNecessaria > getDinheiro())
            throw new RuntimeException("Quantidade de dinheiro indisponível: " + "Quantidade Necessária: "  + quantidadeNecessaria + " Quantidade disponível: " + getDinheiro());

        for(int i = 0; i < quantidade; i++) {
            ativos.add(ativo);
        }

        dinheiro -= quantidadeNecessaria;
    }

    public void vender(Ativo ativo, Corretora corretora, int quantidade){
        if(quantidade <= 0) throw new RuntimeException("Quantidade de ativos deve ser maior que zero");

        double quantidadeAReceber = (ativo.getCotacao() * quantidade) - corretora.getTaxa(ativo, quantidade);

        for(int i = 0; i < quantidade; i++) {
            ativos.remove(ativo);
        }

        dinheiro += quantidadeAReceber;
    }

    public double getDinheiro(){
        return dinheiro;
    }


    public String getNome() {
        return nome;
    }

    public DynamicArray<Ativo> getAtivos() {
        return ativos;
    }

    @Override
    public String toString() {
        return "Investidor{" +
                "nome='" + nome + '\'' +
                ", ativos=" + ativos +
                ", dinheiro=" + dinheiro +
                '}';
    }
}
