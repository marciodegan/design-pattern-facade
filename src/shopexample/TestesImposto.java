package shopexample;

import shopexample.imposto.CalculadoraDeImposto;
import shopexample.imposto.ICMS;
import shopexample.imposto.ISS;
import shopexample.orcamento.ItemOrcamento;
import shopexample.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesImposto {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
        CalculadoraDeImposto calculadora = new CalculadoraDeImposto();

        System.out.println(calculadora.calcular(orcamento, new ISS(null)));
        System.out.println(calculadora.calcular(orcamento, new ISS(new ICMS(null))));
    }
}
