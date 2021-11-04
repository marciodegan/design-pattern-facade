package shopexample;

import shopexample.orcamento.ItemOrcamento;
import shopexample.orcamento.Orcamento;

import java.math.BigDecimal;

public class TesteComposicao {

    public static void main(String[] args) {
        Orcamento antigo = new Orcamento();
        antigo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
        antigo.reprovar();

        Orcamento novo = new Orcamento();
        novo.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        novo.adicionarItem(antigo);
        System.out.println(novo.getValor());
    }
}
