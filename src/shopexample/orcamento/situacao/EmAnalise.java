package shopexample.orcamento.situacao;

import shopexample.orcamento.Orcamento;

import java.math.BigDecimal;

public class EmAnalise extends SituacaoOrcamento {
    public BigDecimal calcularValorDescontoExtra(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal("0.05"));
    }

    // faz toda a transição de estados dentro da classe
    public void aprovar(Orcamento orcamento){
        orcamento.setSituacao(new Aprovado());
    }

    public void reprovar(Orcamento orcamento){
        orcamento.setSituacao(new Reprovado());
    }
}
