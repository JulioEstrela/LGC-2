package bolsa;

import estruturadados.DynamicArray;

public class Bolsa {
    private String nome;
    private DynamicArray<Ativo> ativos;
    private DynamicArray<Corretora> corretoras;

    public Bolsa(String nome, DynamicArray<Corretora> corretoras) {
        this.nome = nome;
        this.ativos = new DynamicArray<>();
        this.corretoras = corretoras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public DynamicArray<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(DynamicArray<Ativo> ativos) {
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
