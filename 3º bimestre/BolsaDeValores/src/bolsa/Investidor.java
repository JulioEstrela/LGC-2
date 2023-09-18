import estruturadados.StaticArray;

public class Investidor {
    private String nome;
    private StaticArray<Ativo> ativos;
    private double dinheiro;

    public Investidor(String nome, float dinheiro) {
        this.nome = nome;
        this.ativos = new StaticArray<>();
        this.dinheiro = dinheiro;
    }

    public void addDinheiro(float dinheiro){
        this.dinheiro += dinheiro;
    }

    public double getDinheiro(){
        return dinheiro;
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


}
