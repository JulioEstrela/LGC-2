package bolsa;
import estruturadados.DynamicArray;

public class Custodiante {
    private String nome;
    private DynamicArray<Carteira> carteiras;

    public Custodiante(String nome) {
        this.nome = nome;
        this.carteiras = carteiras;
    }

    public String getNome() {
        return nome;
    }

    public DynamicArray<Carteira> getCarteiras() {
        return carteiras;
    }

    public void setCarteiras(DynamicArray<Carteira> carteiras) {
        this.carteiras = carteiras;
    }
}
