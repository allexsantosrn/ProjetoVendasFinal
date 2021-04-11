package model;

import java.util.Collection;
import java.util.HashSet;

//import pagamento.FormaPagamento;

public class Venda {
	
	Comprador comprador;
	Vendedor vendedor;
	FormaPagamento pagamento;	
	
	//Coleção de itens pertencentes à compra/venda.
	private Collection<Produto> itens = new HashSet<>();

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	
	public FormaPagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(FormaPagamento pagamento) {
		this.pagamento = pagamento;
	}

	// Adiciona um produto a coleção de itens da compra/venda.
	public void adicionarItemVenda(Produto produto) {
		itens.add(produto);
	}

	// Retorna os itens adicionados a uma compra/venda.
	public void getItensVenda() {
		int i = 1;
		System.out.println("Itens da venda: ");
		for (Produto produto : itens) {

			System.out.println("Produto" + "[" + i + "] -" + " Código: " + produto.getCodigo() + " - Nome: "
					+ produto.getNome() + " - Preço Unitário: " + produto.getPrecoUnitario());
			i++;
		}
		System.out.println("");
	}
	
	//Retorna true caso o item adicionado já esteja presente na venda.
	public boolean hasItemVenda (Produto produto) {
		
		boolean existe = false;
		
		if (itens.contains(produto)) {
			existe = true;
			System.out.println("");
			System.out.println("Já existe um produto com o código informado nesta venda.");
			System.out.println("");
		}
		
		return existe;
		
	}

}
