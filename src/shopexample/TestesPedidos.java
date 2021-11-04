package shopexample;

import shopexample.pedido.GeraPedido;
import shopexample.pedido.GeraPedidoHandler;
import shopexample.pedido.acao.LogDePedido;
import shopexample.pedido.acao.EnviarEmailPedido;
import shopexample.pedido.acao.SalvarPedidoNoBancoDeDados;

import java.math.BigDecimal;
import java.util.Arrays;

public class TestesPedidos {

    public static void main(String[] args) {

        GeraPedido gerador = new GeraPedido("cliente", BigDecimal.TEN, 5);
        GeraPedidoHandler handler = new GeraPedidoHandler(
                Arrays.asList(new SalvarPedidoNoBancoDeDados(), new EnviarEmailPedido(),
                        new LogDePedido()));
        handler.execute(gerador);
    }
}
