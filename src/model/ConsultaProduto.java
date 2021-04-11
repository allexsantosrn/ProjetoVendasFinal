package model;

import java.util.Collection;
import java.util.HashSet;

public class ConsultaProduto {

	private Collection<Produto> produtos = new HashSet<>();

	// Adiciona um produto a coleção de produtos.
	public void adicionarProduto(Produto produto) {

		if (produtos.contains(produto)) {
			System.out.println("");
			System.out.println("Já existe um produto com o código informado na base de dados.");
			System.out.println("");
		}

		else {
			produtos.add(produto);
			System.out.println("");
			System.out.println("Produto cadastrado com sucesso.");
			System.out.println("");
		}

	}

	// Retorna true caso o produto seja identificado na lista de produtos.
	public boolean hasProduto(int codigo) {

		boolean existe = false;

		for (Produto produto : produtos) {

			if (produto.getCodigo() == codigo) {
				existe = true;
			}
		}

		return existe;
	}

	// Realiza a consulta do produto pelo código
	public void consultarProduto(int codigo) {

		if (hasProduto(codigo)) {

			for (Produto produto : produtos) {

				if (produto.getCodigo() == codigo) {
					System.out.println("");
					System.out.println(produto);
					System.out.println("");
					break;
				}
			}
		}

		else {
			System.out.println("");
			System.out.println("Não foram localizados produtos com o código informado.");
			System.out.println("");
		}

	}

	// Retorna a lista de produtos
	public void listarProdutos() {

		if (produtos.isEmpty()) {
			System.out.println("");
			System.out.println("Não há registro de produtos na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Produto produto : produtos) {

				System.out.println("Produto" + "[" + i + "] -" + " Código: " + produto.getCodigo() + " - Nome: "
						+ produto.getNome() + " - Preço Unitário: " + produto.getPrecoUnitario());
				i++;
			}

			System.out.println("");

		}

	}

	// Retorna o objeto produto pelo seu código
	public Produto retornaProdutoByCodigo(int codigo) {

		Produto produtox = new Produto();

		for (Produto produto : produtos) {

			if (produto.getCodigo() == codigo) {
				produtox = produto;
			}
		}

		return produtox;
	}

	public String retornaNomeProduto(int codigo) {

		String retorno = "Produto";

		if (hasProduto(codigo)) {

			for (Produto produto : produtos) {

				if (produto.getCodigo() == codigo) {

					retorno = produto.getNome();

					break;
				}
			}
		}

		return retorno;
	}

	public String retornaCodigoProduto(int codigo) {

		String retorno = "Produto";

		if (hasProduto(codigo)) {

			for (Produto produto : produtos) {

				if (produto.getCodigo() == codigo) {

					int codigox = produto.getCodigo();
					retorno = String.valueOf(codigox);

					break;
				}
			}
		}

		return retorno;
	}

	public String retornaPrecoProduto(int codigo) {

		String retorno = "Produto";

		if (hasProduto(codigo)) {

			for (Produto produto : produtos) {

				if (produto.getCodigo() == codigo) {

					double preco = produto.getPrecoUnitario();
					retorno = String.valueOf(preco);

					break;
				}
			}
		}

		return retorno;
	}

}
