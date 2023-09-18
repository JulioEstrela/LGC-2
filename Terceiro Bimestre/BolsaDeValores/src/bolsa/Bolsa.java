package bolsa;

import estruturadados.StaticArray;

public class Bolsa {
    private String nome;
    private StaticArray<Ativo> ativos;
    private StaticArray<Corretora> corretoras;

    public Bolsa(String nome, StaticArray<Corretora> corretoras) {
        this.nome = nome;
        this.ativos = new StaticArray<>();
        this.corretoras = corretoras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StaticArray<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(StaticArray<Ativo> ativos) {
        this.ativos = ativos;
    }

    public void addCorretora(Corretora corretora) {
        this.corretoras.add(corretora);
    }

    @Override
    public String toString() {
        return "Bolsa{" +
                "nome='" + nome + '\'' +
                ", ativos=" + ativos +
                ", corretoras=" + corretoras +
                '}';
    }
}
