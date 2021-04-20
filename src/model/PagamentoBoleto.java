package model;

import java.time.LocalDate;

public class PagamentoBoleto extends FormaPagamento{
	
	/*
	private Date dataVencimento;
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	
	//M�todo que converte a data de vencimento de String para Date.
	public void setDataVencimento(String dataVencimento) throws ParseException {
		this.dataVencimento = formatador.parse(dataVencimento);
	} */
	
	//M�todo que realiza o pagamento por boleto banc�rio.
	public void realizarPagamento(Vendedor vendedor, Comprador comprador, double valorCompra, LocalDate dataPagamento)	 {

		/*
		Date dataVencimentoConvertida = null;
		try {
			dataVencimentoConvertida = convertStringtoDate(dataVencimento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date dataPagamentoConvertida = null;
		try {
			dataPagamentoConvertida = convertStringtoDate(dataPagamento);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */

		/*
		if (!checarFundos(comprador, valorCompra)) {

			System.out.println("O comprador n�o possui fundos para realiza��o da compra.");
			System.out.println("");
		} */
		
		/*
		else if (!verificavencimento(dataVencimentoConvertida, dataPagamentoConvertida)) {

			System.out.println(
					"Boleto vencido. Não é permitido realizar pagamentos após a data de vencimento do boleto.");
			System.out.println("");
		} */

		//else {

			double creditoVendedor = valorCompra - valorEmissaoBoleto;
			comprador.debitaSaldoComprador(valorCompra);
			comprador.incrementaComprasRealizadas();

			vendedor.incrementaValoresaReceber(creditoVendedor);
			vendedor.incrementaVendasRealizadas();

			System.out.println("Pagamento realizado com sucesso.");
			System.out.println("");

		//}

	}
	
	
}
