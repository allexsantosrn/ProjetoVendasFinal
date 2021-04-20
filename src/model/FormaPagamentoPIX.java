package model;

import java.time.LocalDate;

public class FormaPagamentoPIX extends FormaPagamento {

	// Método que realiza o pagamento por PIX.

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

			System.out.println("O comprador não possui fundos para realização da compra.");
			System.out.println("");
		}

	}

}
