package model;

import java.util.Collection;
import java.util.HashSet;


public class ConsultaVendedor {

	private Collection<Vendedor> vendedores = new HashSet<>(); //Cole��o de vendedores.

	//Adiciona um vendedor a cole��o de vendedores.
	public void adicionarVendedor(Vendedor vendedor) {

		if (vendedores.contains(vendedor)) {
			System.out.println("");
			System.out.println("J� existe um vendedor com o cnpj informado na base de dados.");
			System.out.println("");
		}

		else {
			vendedores.add(vendedor);
			System.out.println("");
			System.out.println("Vendedor "+vendedor.getNome()+" cadastrado com sucesso.");
			System.out.println("");
		}

	}

	// Retorna true caso o vendedor seja identificado na lista de vendedores.
	public boolean hasVendedor(String cnpj) {

		boolean existe = false;

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				existe = true;
			}
		}

		return existe;
	}

	//Realiza a consulta de um vendedor.
	
	public void consultarVendedor(String cnpj) {

		if (hasVendedor(cnpj)) {

			for (Vendedor vendedor : vendedores) {

				if (vendedor.getCnpj().equals(cnpj)) {
					System.out.println("");
					System.out.println(vendedor);					
					vendedor.getProdutosCatalogo();					
					vendedor.getVenda();
					break;
				}
			}
		}

		else {
			System.out.println("");
			System.out.println("Não foram localizados vendedores com o CPF informado.");
			System.out.println("");
		}

	} 
	
	
	//Retorna a listagem de vendedores.
	public void listarVendedores() {

		if (vendedores.isEmpty()) {
			System.out.println("");
			System.out.println("N�o h� registro de vendedores na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Vendedor vendedor : vendedores) {
				System.out.println("vendedor" + "[" + i + "] -" + " CPNJ: " + vendedor.getCnpj() + " - Nome: "
						+ vendedor.getNome());
				i++;
			}

			System.out.println("");

		}

	}
	
	//Retorna true caso a lista de vendedores seja vazia.
	public boolean listaVendedoresIsEmpty() {

		boolean vazio = false;

		if (vendedores.isEmpty()) {

			vazio = true;
		}

		return vazio;
	}
	
	//Recebe um CNPJ e um produto para adi��o ao cat�logo do vendedor.
	
	public void adicionarItemCatalogo(String cnpj, Produto produto) {

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				vendedor.adicionarItemCatalogo(produto);
				System.out.println("Item "+produto.getNome()+ " adicionado ao cat�logo com sucesso!");
			}
		}
	} 

	//Retorna um objeto Vendedor atrav�s do CNPJ.
	public Vendedor retornaVendedorByCNPJ(String cnpj) {

		Vendedor vendedorx = new Vendedor();

		for (Vendedor vendedor : vendedores) {

			if (vendedor.getCnpj().equals(cnpj)) {
				vendedorx = vendedor;
			}
		}

		return vendedorx;
	}
	
	//Retorna true caso o c�digo do produto informado exista no cat�logo do vendedor.
	
	public boolean hasProdutoCatalogo(Vendedor vendedor, int codigo) {

		boolean existe = false;

		if (vendedor.hasProdutoCatalogo(codigo)) {

			existe = true;
		}

		return existe;
	} 
	
	//Recebe uma venda para adi��o a listagem de vendas do vendedor.	
	public void adicionarVenda(Vendedor vendedor, Venda venda) {

		vendedor.adicionarVenda(venda);
	} 
	
	public String retornaNomeVendedor (String cnpj) {
		
		String retorno = "Vendedor";
		
		if (hasVendedor(cnpj)) {

			for (Vendedor vendedor : vendedores) {

				if (vendedor.getCnpj().equals(cnpj)) {
					
					retorno = vendedor.getNome();
					
					break;
				}
			}
		}
		
		return retorno;
	}
	
	public String retornaCNPJVendedor (String cnpj) {
		
		String retorno = "Vendedor";
		
		if (hasVendedor(cnpj)) {

			for (Vendedor vendedor : vendedores) {

				if (vendedor.getCnpj().equals(cnpj)) {
					
					retorno = vendedor.getCnpj();
					
					break;
				}
			}
		}
		
		return retorno;
	}
	
	public String retornaSaldoVendedor (String cnpj) {
			
			String retorno = "Vendedor";
			
			if (hasVendedor(cnpj)) {
	
				for (Vendedor vendedor : vendedores) {
	
					if (vendedor.getCnpj().equals(cnpj)) {
						
						double saldo = vendedor.getSaldo();
						retorno = String.valueOf(saldo);
						
						break;
					}
				}
			}
			
			return retorno;
		}
	
	public String retornaValoresReceberVendedor (String cnpj) {
		
		String retorno = "Vendedor";
		
		if (hasVendedor(cnpj)) {

			for (Vendedor vendedor : vendedores) {

				if (vendedor.getCnpj().equals(cnpj)) {
					
					double valoresReceber = vendedor.getValoresReceber();
					retorno = String.valueOf(valoresReceber);
					
					break;
				}
			}
		}
		
		return retorno;
	}
		
	
}
