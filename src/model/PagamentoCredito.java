package model;

import java.time.LocalDate;

public class PagamentoCredito extends FormaPagamento {

	//Método que realiza o pagamento por cartão de crédito.
	@Override	
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra, LocalDate dataPagamento) {

		double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

		comprador.incrementaValoresaPagar(valorCompra);
		comprador.incrementaComprasRealizadas();

		vendedor.incrementaValoresaReceber(creditoVendedor);
		vendedor.incrementaVendasRealizadas();

		System.out.println("Pagamento realizado com sucesso.");
		System.out.println("");

	}

}
