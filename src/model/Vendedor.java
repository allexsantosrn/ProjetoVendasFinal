package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;

public class Vendedor {

	String cnpj; // CNPJ do vendedor.
	String nome; // Nome do vendedor.
	double saldo; // Saldo do vendedor.
	double valoresReceber = 0; // Total de valores a receber.
	int qtdvendasRealizadas = 0; // Quantidade de vendas realizadas.

	private Collection<Produto> catalogo = new HashSet<>(); // Coleção de produtos - Catálogo
	private Collection<Venda> vendas = new HashSet<>(); // Coleção de vendas realizadas

	private static final DateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

	public Vendedor() {

	}

	public Vendedor(String cnpj, String nome, double saldo) {

		this.cnpj = cnpj;
		this.nome = nome;
		this.saldo = saldo;

	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public double getValoresReceber() {
		return valoresReceber;
	}

	public void setValoresReceber(double valoresReceber) {
		this.valoresReceber = valoresReceber;
	}

	public int getqtdVendasRealizadas() {
		return qtdvendasRealizadas;
	}

	public void setqtdVendasRealizadas(int qtdvendasRealizadas) {
		this.qtdvendasRealizadas = qtdvendasRealizadas;
	}

	// Adiciona um produto ao catÃ¡logo do vendedor.
	public void adicionarItemCatalogo(Produto produto) {
		catalogo.add(produto);
	}

	// Exibe o catálogo de itens do vendedor.

	public void getProdutosCatalogo() {
		int i = 1;
		System.out.println("");
		System.out.println("CatÃ¡logo de Itens: ");
		for (Produto produto : catalogo) {

			System.out.println("Produto" + "[" + i + "] -" + " CÃ³digo: " + produto.getCodigo() + " / Nome: "
					+ produto.getNome() + " / Preço: " + produto.getPrecoUnitario());
			i++;
		}
	}

	// Incrementa o saldo do vendedor.
	public void incrementaSaldoVendedor(double valor) {
		this.saldo = this.saldo + valor;
	}

	// Incrementa o nÃºmero de vendas realizadas pelo vendedor.
	public void incrementaVendasRealizadas() {
		this.qtdvendasRealizadas = this.qtdvendasRealizadas + 1;
	}

	// Incrementa os valores a receber do vendedor.
	public void incrementaValoresaReceber(double valor) {
		this.valoresReceber = this.valoresReceber + valor;
	}

	// Retorna true caso o produto exista no catÃ¡logo do vendedor.
	public boolean hasProdutoCatalogo(int codigo) {

		boolean existe = false;

		for (Produto produto : catalogo) {

			if (produto.getCodigo() == codigo) {
				existe = true;
			}
		}

		return existe;
	}

	// Adiciona uma venda a coleÃ§Ã£o de vendas.
	public void adicionarVenda(Venda venda) {
		vendas.add(venda);
	}

	// Imprime as vendas do vendedor.

	public void getVenda() {
		int i = 1;
		System.out.println("");
		System.out.println("Vendas Realizadas: ");

		for (Venda venda : vendas) {

			System.out.println("Compra" + "[" + i + "] -" + " Valor Total: " + venda.getPagamento().getValorTotal()
					+ " / Tipo de Pagamento: " + venda.getPagamento().getTipoPagamento() + " / Data de Pagamento: "
					+ formatador.format(venda.getPagamento().getDataPagamento()));
			venda.getItensVenda();
			i++;
		}
	}

	@Override
	public String toString() {
		return "CNPJ: " + this.cnpj + "\nNome: " + this.nome + "\nSaldo: " + this.saldo + "\nValores a Receber: "
				+ this.valoresReceber + "\nQtd. Vendas Realizadas: " + this.qtdvendasRealizadas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
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
		Vendedor other = (Vendedor) obj;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		return true;
	}

}
