public class Acao extends Ativo{

    public Acao(String nome, String codigo, double cotacao, int lotePadrao, double dividendos) {
        super(nome, codigo, cotacao, lotePadrao, dividendos);
    }

    public Acao(String nome, String codigo, double cotacao, int lotePadrao) {
        super(nome, codigo, cotacao, lotePadrao, 0);
    }
}
