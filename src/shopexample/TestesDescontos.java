package shopexample;

import shopexample.desconto.CalculadoraDeDescontos;

import shopexample.orcamento.ItemOrcamento;
import shopexample.orcamento.Orcamento;

import java.math.BigDecimal;

public class TestesDescontos {
    public static void main(String[] args) {
        Orcamento orcamento1 = new Orcamento();
        orcamento1.adicionarItem(new ItemOrcamento(new BigDecimal("300")));

        Orcamento orcamento2 = new Orcamento();
        orcamento2.adicionarItem(new ItemOrcamento(new BigDecimal("1000")));

        Orcamento orcamento3 = new Orcamento();
        orcamento3.adicionarItem(new ItemOrcamento(new BigDecimal("2000")));

        CalculadoraDeDescontos calculadora = new CalculadoraDeDescontos();
        System.out.println("Total de Desconto: " + calculadora.calcular(orcamento1));
        System.out.println("Total de Desconto: " + calculadora.calcular(orcamento2));
    }
}
