# Projeto Final de Linguagem de Programa��o II



### Projeto-Vendas-Final



**Componentes:**


- Alexandre Dantas dos Santos



**Professor:**
	

- Vin�cius Mendes



## Objetivo


O objetivo deste trabalho � implementar um programa de cadastro de venda, possibilitando o registro das vendas via interface gr�fica do JavaFX.



## Tarefa


Foi implementado um sistema de controle de vendas via interface gr�fica em JavaFX.

Segue checklist de itens cumpridos de acordo com o checklist estabelecido dos requisitos da tarefa.

- O sistema deve possuir uma interface gr�fica para cadastrar compras. (No pequeno sistema desenvolvido existe a interface de cadastro das compras/vendas)
- A interface gr�fica deve implementar uma estrutura de carrinho de compras que vai sendo preenchido � medida que o usu�rio inclui os itens. (Item desenvolvido)
- A interface gr�fica deve permitir imprimir os dados de um comprador com base no seu CPF. (H� a interface gr�fica para consulta do comprador)
- A interface gr�fica deve permitir imprimir os dados de um vendedor com base no seu CNPJ. (H� a interface gr�fica para consulta do vendedor)
- Se a data de validade do boleto j� tiver expirado, o sistema deve lan�ar uma exce��o. (Foi adicionada uma regra de neg�cio que impede que o pagamento de um boleto expirado seja realizado)
- As exce��es devem ser tratadas com mensagens amig�veis aos usu�rios. (Foram adicionadas mensagens de exce��es para os usu�rios).
- Utilize uma classe abstrata FormaPagamento com um m�todo abstrato para tratar o pagamento. (Foi desenvolvida a cria��o da classe abstrata: FormaPagamento)
- Crie uma classe concreta para cada forma de pagamento que herde de FormaPagamento e implemente o m�todo abstrato. (Desenvolvido conforme solicitado)
- Utilize corretamente o pacote java.time (Foi utilizado na verifica��o de boletos vencidos. Utilizado tamb�m nos objetos LocalDate)
- Utilize corretamente o tipo especial Enum. (Foi utilizado na classe enum: FormasPagamento, que identifica os 4 tipos de pagamentos poss�veis)
- Utilize pelo menos uma annotation de marca��o. (Foi utilizado o @Override no m�todo realizarPagamento das classes concretas filhas da classe abstrata: FormaPagamento. Al�m disso, na classe abstrata: FormaPagamento foi adicionada a 
annotation @Deprecated para alguns m�todos que eram utilizados nos objetos do tipo Date - Esses objetos foram convertidos no tipo LocalDate).

O link do reposit�rio do projeto � este: https://github.com/allexsantosrn/ProjetoVendasFinal.




## Opera��es suportadas

	

1 - Cadastrar Venda; (Possibilita o cadastro da venda).
2 - Consultar Comprador; (Permite a consulta do comprador por meio do CPF).
3 - Consultar Vendedor;
 (Permite a consulta do vendedor por meio do CNPJ).
4 - Cadastrar Produto;
 (Permite a consulta do produto por meio do seu c�digo).	


No registro do pagamento � poss�vel realizar os seguintes tipos de pagamento: 


	
1 - Pagamento por PIX;
	
2 - Pagamento por Boleto;
	
3 - Pagamento por Cart�o de Cr�dito;
	
4 - Pagamento por Cart�o de D�bito;



- Para pagamento por PIX, o comprador necessita ter fundos para realiza��o da compra, neste ponto, haver� transfer�ncia de recursos do comprador para o vendedor.

- Para pagamento por Boleto, o comprador necessita ter fundos para realiza��o da compra. Al�m disso, dever� ser informada tamb�m a data de vencimento do boleto, n�o podendo este boleto estar vencido para pagamento. Por fim, haver� transfer�ncia de recursos do comprador para a �rea de recursos a receber do vendedor, havendo tamb�m um desconto de 1 real pela gera��o do boleto.

- Para pagamento por Cart�o de Cr�dito, n�o haver� necessidade do comprador ter fundos para pagamento. Neste ponto, haver� incremento dos registros de valores a pagar do comprador, e na �rea de valores a receber do vendedor, havendo tamb�m uma taxa de desconto 2% da operadora de cart�o.

- Para pagamento por D�bito, o comprador necessita ter fundos para realiza��o da compra, neste ponto, haver� transfer�ncia de recursos do comprador para a area de recursos a receber do vendedor, havendo tamb�m uma taxa de desconto 2% da operadora de cart�o.

OBS: Em todas as formas de pagamento, ser� considerada a data atual como data de pagamento.

Na realiza��o da venda, alguns regras de neg�cio foram adicionadas (Com op��es de alertas sendo exibidos para o usu�rio):

- O usu�rio n�o poder� adicionar o produto mais de uma vez, durante sua compra;
- Caso o produto n�o esteja no cat�logo do vendedor selecionado, ser� exibida uma mensagem de alerta.
- Caso o boleto esteja vencido, n�o ser� poss�vel realizar seu pagamento.
- Caso o usu�rio n�o possua saldo suficiente n�o ser� poss�vel realizar um pagamento.

A interface de venda tamb�m permite a visualiza��o das informa��es do comprador, vendedor e produto em tela, incluindo a� os valores de saldo atualizados do vendedor e comprador. 

Foram desenvolvidos tamb�m o bot�o de voltar, em cada tela. Na venda, tamb�m foram adicionadas as op��es de reiniciar compra, limpar carrinho e de adicionar itens ao carrinho de compras.


## Base de dados

Ao iniciar o sistema s�o criados automaticamente os compradores com CPF�s: 1, 2 e 3.

ao iniciar o sistema s�o criados automaticamente os vendedores com CNPJ�s: 1, 2 e 3.

Ao iniciar o sistema s�o criados automaticamente os produtos com c�digos de 1 a 9.

Os itens de c�digos de 1 a 3 est�o associados ao vendedor de CNPJ = 1.

Os itens de c�digos de 4 a 6 est�o associados ao vendedor de CNPJ = 2.

Os itens de c�digos de 7 a 9 est�o associados ao vendedor de CNPJ = 3.



