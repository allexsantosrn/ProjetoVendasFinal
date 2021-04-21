# Projeto Final de Linguagem de Programação II



### Projeto-Vendas-Final



**Componentes:**


- Alexandre Dantas dos Santos



**Professor:**
	

- Vinícius Mendes



## Objetivo


O objetivo deste trabalho é implementar um programa de cadastro de venda, possibilitando o registro das vendas via interface gráfica do JavaFX.



## Tarefa


Foi implementado um sistema de controle de vendas via interface gráfica em JavaFX.

Segue checklist de itens cumpridos de acordo com o checklist estabelecido dos requisitos da tarefa.

- O sistema deve possuir uma interface gráfica para cadastrar compras. (No pequeno sistema desenvolvido existe a interface de cadastro das compras/vendas)
- A interface gráfica deve implementar uma estrutura de carrinho de compras que vai sendo preenchido à medida que o usuário inclui os itens. (Item desenvolvido)
- A interface gráfica deve permitir imprimir os dados de um comprador com base no seu CPF. (Há a interface gráfica para consulta do comprador)
- A interface gráfica deve permitir imprimir os dados de um vendedor com base no seu CNPJ. (Há a interface gráfica para consulta do vendedor)
- Se a data de validade do boleto já tiver expirado, o sistema deve lançar uma exceção. (Foi adicionada uma regra de negócio que impede que o pagamento de um boleto expirado seja realizado)
- As exceções devem ser tratadas com mensagens amigáveis aos usuários. (Foram adicionadas mensagens de exceções para os usuários).
- Utilize uma classe abstrata FormaPagamento com um método abstrato para tratar o pagamento. (Foi desenvolvida a criação da classe abstrata: FormaPagamento)
- Crie uma classe concreta para cada forma de pagamento que herde de FormaPagamento e implemente o método abstrato. (Desenvolvido conforme solicitado)
- Utilize corretamente o pacote java.time (Foi utilizado na verificação de boletos vencidos. Utilizado também nos objetos LocalDate)
- Utilize corretamente o tipo especial Enum. (Foi utilizado na classe enum: FormasPagamento, que identifica os 4 tipos de pagamentos possíveis)
- Utilize pelo menos uma annotation de marcação. (Foi utilizado o @Override no método realizarPagamento das classes concretas filhas da classe abstrata: FormaPagamento. Além disso, na classe abstrata: FormaPagamento foi adicionada a 
annotation @Deprecated para alguns métodos que eram utilizados nos objetos do tipo Date - Esses objetos foram convertidos no tipo LocalDate).

O link do repositório do projeto é este: https://github.com/allexsantosrn/ProjetoVendasFinal.




## Operações suportadas

	

1 - Cadastrar Venda; (Possibilita o cadastro da venda).
2 - Consultar Comprador; (Permite a consulta do comprador por meio do CPF).
3 - Consultar Vendedor;
 (Permite a consulta do vendedor por meio do CNPJ).
4 - Cadastrar Produto;
 (Permite a consulta do produto por meio do seu código).	


No registro do pagamento é possível realizar os seguintes tipos de pagamento: 


	
1 - Pagamento por PIX;
	
2 - Pagamento por Boleto;
	
3 - Pagamento por Cartão de Crédito;
	
4 - Pagamento por Cartão de Débito;



- Para pagamento por PIX, o comprador necessita ter fundos para realização da compra, neste ponto, haverá transferência de recursos do comprador para o vendedor.

- Para pagamento por Boleto, o comprador necessita ter fundos para realização da compra. Além disso, deverá ser informada também a data de vencimento do boleto, não podendo este boleto estar vencido para pagamento. Por fim, haverá transferência de recursos do comprador para a área de recursos a receber do vendedor, havendo também um desconto de 1 real pela geração do boleto.

- Para pagamento por Cartão de Crédito, não haverá necessidade do comprador ter fundos para pagamento. Neste ponto, haverá incremento dos registros de valores a pagar do comprador, e na área de valores a receber do vendedor, havendo também uma taxa de desconto 2% da operadora de cartão.

- Para pagamento por Débito, o comprador necessita ter fundos para realização da compra, neste ponto, haverá transferência de recursos do comprador para a area de recursos a receber do vendedor, havendo também uma taxa de desconto 2% da operadora de cartão.

OBS: Em todas as formas de pagamento, será considerada a data atual como data de pagamento.

Na realização da venda, alguns regras de negócio foram adicionadas (Com opções de alertas sendo exibidos para o usuário):

- O usuário não poderá adicionar o produto mais de uma vez, durante sua compra;
- Caso o produto não esteja no catálogo do vendedor selecionado, será exibida uma mensagem de alerta.
- Caso o boleto esteja vencido, não será possível realizar seu pagamento.
- Caso o usuário não possua saldo suficiente não será possível realizar um pagamento.

A interface de venda também permite a visualização das informações do comprador, vendedor e produto em tela, incluindo aí os valores de saldo atualizados do vendedor e comprador. 

Foram desenvolvidos também o botão de voltar, em cada tela. Na venda, também foram adicionadas as opções de reiniciar compra, limpar carrinho e de adicionar itens ao carrinho de compras.


## Base de dados

Ao iniciar o sistema são criados automaticamente os compradores com CPF´s: 1, 2 e 3.

ao iniciar o sistema são criados automaticamente os vendedores com CNPJ´s: 1, 2 e 3.

Ao iniciar o sistema são criados automaticamente os produtos com códigos de 1 a 9.

Os itens de códigos de 1 a 3 estão associados ao vendedor de CNPJ = 1.

Os itens de códigos de 4 a 6 estão associados ao vendedor de CNPJ = 2.

Os itens de códigos de 7 a 9 estão associados ao vendedor de CNPJ = 3.



