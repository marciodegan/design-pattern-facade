## Design Pattern - Facade

- This is a continuation of: https://github.com/marciodegan/design-pattern-composite

### Notes:
- Precisamos implementar nova ação ao Gerar Pedido.
- Será criada uma nova classe "LogDePedido" que implementa a interface AcaoAposGerarPedido.
- Não será necessário mexer na classe GeraPedidoHandler
- Só é necessário passar a nova ação como parâmetro.

---
**Exemplo - uma aplicação para fazer transferência entre contas:**
- Digamos que para fazer uma transferência é necessário chamar vários métodos.

- Conta minhaConta = new Conta();Conta outraConta = new Conta();
- BigDecimal transferencia = new Transferencia();
- transferencia.validarConta(minhaConta);
- transferencia.validarConta(outraConta);
- transferencia.checarSaldo(minhaconta, valorTransferencia);
- transferencia.executar(minhaConta, outraConta, valorTransferencia);

> Então seria muito mais facil se chamássemos apenas um método por exemplo: **transferencia.executar(minhaConta, outraConta, valorTransferencia)**
- O padrão Facade é uma "fachada" com outras classes...uma classe A, que chama uma classe B, C e D e não queremos expor isso para o cliente.
- O cliente não precisa saber quais classes chamar e nem a ordem. Então encapsulamos em um método.

---

> From the Book Heads Up - Design Pattern
- Para usar o padrão Facade, criamos uma classe que simplifica e unifica um conjunto de classes mais complexas pertencentes a alguma subsistema.
- O Facade pattern fornece uma interface unificada para um conjunto de interfaces em um subsistema. A fachada define uma interface de nivel mais alto que facilita a utilizacao do subsistema.

- Cliente -> Classe Fachada -> Variedade e Complexas Classes do subsistema


### Princípio do Conhecimento Mínimo
- este princípio nos orienta a reduzir as interações entre objetos, limitando-as a apenas alguns "amigos" mais próximos. "Só fale com seus amigos mais próximos".
- Ao projetar um sistema, devemos tomar cuidado com o número de classes com que qualquer objeto interage e também com a forma como essa interação ocorre.
- Este princípio nos impede de criar projetos com um grande número de classes interconectadas, o que faz com que qualquer alteração numa parte do sistema exerça um efeito em cascata sobre outras partes.
- Um sistema com muitas dependências entre múltiplas classes é um sistema frágil, de dificil manutencao e completo demais para ser compreendido por outros.

### Como evitar isso:
**Pegamos um objeto qualquer e, a partir de qualquer método nesse objeto, só podemos invocar métodos que pertençam:**
- Ao próprio objeto
- A objetos que tenham sido passados como parâmetros para o método
- A qualquer objeto que seja criado ou instanciado pelo método
- A quaisquer componentes do objeto.

> Mais uma analogia é o HomeTheater
> 
> Cliente -> HomeTheaterFacade  -> subsistemas dvdplayer, cdplayer, luz ambient, sintonizador, amplificador.

- Em determinados casos, nós podemos precisar de um acesso simplificado a uma parte complexa ou grande do nosso sistema, como autenticação, acesso a sistema de arquivos, cache, etc. Uma classe de fachada, contendo apenas a funcionalidade desejada, pode ser bastante útil.
- More: https://refactoring.guru/design-patterns/facade