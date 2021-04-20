package model;

import java.time.LocalDate;

public class FormaPagamentoPIX extends FormaPagamento {

	// M�todo que realiza o pagamento por PIX.

	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra, LocalDate dataPagamento) {

		if (checarFundos(comprador, valorCompra)) {

			comprador.debitaSaldoComprador(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaSaldoVendedor(valorCompra);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
			System.out.println("");
		}

		else {

			System.out.println("O comprador n�o possui fundos para realiza��o da compra.");
			System.out.println("");
		}

	}

}
