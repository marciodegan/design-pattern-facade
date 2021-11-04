package shopexample.orcamento;

import shopexample.http.HttpAdapter;
import shopexample.DomainException;

import java.util.Map;

public class RegistroDeOrcamento {

    private HttpAdapter http;

    public RegistroDeOrcamento(HttpAdapter http) {
        this.http = http;
    }

    public void registrar(Orcamento orcamento){
        if(!orcamento.isFinalizado()){
            throw new DomainException("Orcamento não finalizado");

        }
        String url = "https://jsonplaceholder.typicode.com/posts";
        Map<String, Object> dados = Map.of(
                "valor", orcamento.getValor(),
                "quantidadeItens", orcamento.getQuantidadeItens()
        );
        System.out.println("jiofdsfsd");
        http.post(url, dados);
    }
}
