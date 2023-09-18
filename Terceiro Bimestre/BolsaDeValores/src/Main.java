import bolsa.*;
import estruturadados.DynamicArray;

public class Main {
    public static void main(String[] args) {
        Investidor investidor1 = new Investidor("Júlio", 1000);

        Corretora corretora1 = new Corretora("XP", 2);
        Corretora corretora2 = new Corretora("BTG Pactual", 5);
        Corretora corretora3 = new Corretora("Credit Suisse", 10);

        Bolsa bolsa = new Bolsa("B3", DynamicArray.of(corretora1, corretora2, corretora3));

        Acao acao1 = new Acao("Petroleo Brasileiro SA", "PETR4", 33.89, 100);
        Acao acao2 = new Acao("Vale SA", "VALE3", 69.54, 100);
        FII fii1 = new FII("Bradesco Carteira Imobiliaria Ativa", "BCIA11", 101.94, 1, 0.83);



        DynamicArray<Ativo> ativos = new DynamicArray<>();

        investidor1.comprar(acao1, corretora1, 1);
        investidor1.comprar(acao2, corretora2, 1);
        investidor1.comprar(fii1, corretora2, 4);

        System.out.println(investidor1.getAtivos());
        System.out.println(bolsa);

    }
}