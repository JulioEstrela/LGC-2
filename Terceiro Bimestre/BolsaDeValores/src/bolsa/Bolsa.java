package bolsa;
import estruturadados.DynamicArray;

public class Bolsa {
    private String nome;
    private DynamicArray<Corretora> corretoras;

    public Bolsa(String nome, DynamicArray<Corretora> corretoras) {
        this.nome = nome;
        this.corretoras = corretoras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addCorretora(Corretora corretora) {
        this.corretoras.add(corretora);
    }

    @Override
    public String toString() {
        return "Bolsa{" +
                "nome='" + nome + '\'' +
                ", corretoras=" + corretoras +
                '}';
    }
}
