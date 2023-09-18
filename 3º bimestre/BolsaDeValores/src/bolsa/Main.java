import estruturadados.StaticArray;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Investidor investidor1 = new Investidor("Júlio", 10);

        Corretora corretora1 = new Corretora("XP", 2);
        Corretora corretora2 = new Corretora("BTG Pactual", 5);
        Corretora corretora3 = new Corretora("Credit Suisse", 10);

        Bolsa bolsa = new Bolsa("B3", StaticArray.of(corretora1, corretora2, corretora3));

        Acao acao1 = new Acao("Petroleo Brasileiro SA", "PETR4", 33.89, 100);


        List<Ativo> ativos = new ArrayList<>();

        ativos.add(acao1);

        System.out.println(ativos);
        System.out.println(bolsa);

    }
}