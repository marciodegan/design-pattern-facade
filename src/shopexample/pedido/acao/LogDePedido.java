package shopexample.pedido.acao;

import shopexample.pedido.AcaoAposGerarPedido;
import shopexample.pedido.Pedido;

public class LogDePedido implements AcaoAposGerarPedido {

    public void executarAcao(Pedido pedido) {
        System.out.println("Pedido foi gerado: " + pedido);
    }
}
