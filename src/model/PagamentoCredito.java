package model;

public class PagamentoCredito extends FormaPagamento {

	//M�todo que realiza o pagamento por cart�o de cr�dito.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra) {

		double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

		comprador.incrementaValoresaPagar(valorCompra);
		comprador.incrementaComprasRealizadas();

		vendedor.incrementaValoresaReceber(creditoVendedor);
		vendedor.incrementaVendasRealizadas();

		System.out.println("Pagamento realizado com sucesso.");
		System.out.println("");

	}

}
