package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;

public class Comprador {	

	private String cpf; //Cpf do comprador.
	private String nome; //Nome do comprador.
	private double saldo; //Saldo do comprador.
	private double valoresaPagar = 0; //Total de valores a pagar do comprador.
	private int qtdcomprasRealizadas = 0; //N�mero de compras realizadas pelo comprador.

	private Collection<Venda> compras = new HashSet<>(); //Cole��o de compras do comprador.

	private static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
	
	public Comprador() {
		
	}	

	public Comprador(String cpf, String nome, double saldo) {
		this.cpf = cpf;
		this.nome = nome;
		this.saldo = saldo;		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public double getValoresaPagar() {
		return valoresaPagar;
	}

	public void setValoresaPagar(double valoresaPagar) {
		this.valoresaPagar = valoresaPagar;
	}

	public int getComprasRealizadas() {
		return qtdcomprasRealizadas;
	}

	public void setqtdComprasRealizadas(int qtdcomprasRealizadas) {
		this.qtdcomprasRealizadas = qtdcomprasRealizadas;
	}	

	//Adiciona uma compra/venda a cole��o de compras.	
	public void adicionarCompra(Venda venda) {
		compras.add(venda);
	}

	//Retorna os itens comprados pelo comprador.
	public void getCompra() {
		int i = 1;		
		System.out.println("");
		System.out.println("Compras Realizadas: ");		
		for (Venda venda : compras) {

			System.out.println("Compra" + "[" + i + "] -" + " Valor Total: " + venda.getPagamento().getValorTotal()
					+ " / Tipo de Pagamento: " + venda.getPagamento().getTipoPagamento() + " / Data de Pagamento: "
					+ formatador.format(venda.getPagamento().getDataPagamento()));
			venda.getItensVenda();			
			i++;
		}		
	} 
	
	//Debita o saldo do vendedor.
	public void debitaSaldoComprador(double valor) {
		this.saldo = this.saldo - valor;
	}

	//Incrementa o número de compras realizadas pelo comprador.
	public void incrementaComprasRealizadas() {
		this.qtdcomprasRealizadas = this.qtdcomprasRealizadas + 1;
	}
	
	//Incrementa os valores a pagar pelo comprador.
	public void incrementaValoresaPagar(double valor) {
		this.valoresaPagar = this.valoresaPagar + valor;
	}

	@Override
	public String toString() {
		return "CPF: " + this.cpf + "\nNome: " + this.nome + "\nSaldo: " + this.saldo + "\nValores a Pagar: "
				+ this.valoresaPagar + "\nQtd. Compras Realizadas: " + this.qtdcomprasRealizadas;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comprador other = (Comprador) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
