package shopexample.pedido.acao;

import shopexample.pedido.AcaoAposGerarPedido;
import shopexample.pedido.Pedido;

public class EnviarEmailPedido implements AcaoAposGerarPedido {

    public void executarAcao(Pedido pedido) {
        System.out.println("Enviando email do pedido");
    }
}
