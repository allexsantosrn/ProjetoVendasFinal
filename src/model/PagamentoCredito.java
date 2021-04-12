package model;

public class PagamentoCredito extends FormaPagamento {

	//Método que realiza o pagamento por cartão de crédito.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra) {

		double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

		comprador.incrementaValoresaPagar(valorCompra);
		comprador.incrementaComprasRealizadas();

		vendedor.incrementaValoresaReceber(creditoVendedor);
		vendedor.incrementaVendasRealizadas();

		System.out.println("Pagamento realizado com sucessoC.");
		System.out.println("");

	}

}
