package shopexample;

import shopexample.http.HttpAdapterImplHtmlURLConnection;
import shopexample.orcamento.ItemOrcamento;
import shopexample.orcamento.Orcamento;
import shopexample.orcamento.RegistroDeOrcamento;

import java.math.BigDecimal;

public class TestesAdapter {
    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento();
        orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("300")));
        orcamento.aprovar();
        orcamento.finalizar();

        RegistroDeOrcamento registro = new RegistroDeOrcamento(new HttpAdapterImplHtmlURLConnection());
        registro.registrar(orcamento);

    }
}
