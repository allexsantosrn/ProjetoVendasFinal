package model;

import java.time.LocalDate;

public class PagamentoDebito extends FormaPagamento {

	//M�todo que realiza o pagamento por d�bito.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra, LocalDate dataPagamento) {

		if (checarFundos(comprador, valorCompra)) {

			double creditoVendedor = valorCompra - (valorCompra * this.taxaOperadora);

			comprador.debitaSaldoComprador(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(creditoVendedor);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
			System.out.println("");

		} else {

			System.out.println("O comprador n�o possui fundos para realiza�� da compra.");
			System.out.println("");
		}

	}
}
