package model;

import java.util.Collection;

import java.util.HashSet;

public class ConsultaComprador extends Comprador {

	private Collection<Comprador> compradores = new HashSet<>(); // Cole��o de compradores.

	// Adiciona um comprador a cole��o de compradores.
	public void adicionarComprador(Comprador comprador) {

		if (compradores.contains(comprador)) {
			System.out.println("");
			System.out.println("J� existe um comprador com o c�digo informado na base de dados.");
			System.out.println("");
		}

		else {
			compradores.add(comprador);
			System.out.println("");
			System.out.println("Comprador " + comprador.getNome() + " cadastrado com sucesso.");
			System.out.println("");
		}

	}

	// Retorna true caso o comprador seja identificado na lista de compradores.
	public boolean hasComprador(String cpf) {

		boolean existe = false;

		for (Comprador comprador : compradores) {

			if (comprador.getCpf().equals(cpf)) {
				existe = true;
			}
		}

		return existe;
	}

	// Retorna os dados de um comprador.

	public void consultarComprador(String cpf) {

		if (hasComprador(cpf)) {

			for (Comprador comprador : compradores) {

				if (comprador.getCpf().equals(cpf)) {
					System.out.println("");
					System.out.println(comprador);
					comprador.getCompra();
					break;
				}
			}
		}

		else {
			System.out.println("");
			System.out.println("N�o foram localizados compradores com o CPF informado.");
			System.out.println("");
		}

	}

	// Retorna a listagem de todos os compradores.
	public void listarCompradores() {

		if (compradores.isEmpty()) {
			System.out.println("");
			System.out.println("N�o h� registro de compradores na base de dados.");
			System.out.println("");
		}

		else {

			int i = 1;
			System.out.println("");

			for (Comprador comprador : compradores) {

				System.out.println("Comprador" + "[" + i + "] -" + " CPF: " + comprador.getCpf() + " - Nome: "
						+ comprador.getNome());
				i++;
			}

			System.out.println("");

		}

	}

	// Retorna um objeto comprador através do cpf do comprador.
	public Comprador retornaCompradorByCPF(String cpf) {

		Comprador compradorx = new Comprador();

		for (Comprador comprador : compradores) {

			if (comprador.getCpf().equals(cpf)) {
				compradorx = comprador;
			}
		}

		return compradorx;
	}

	// Recebe uma compra para adi��o a listagem de compras do vendedor.
	/*
	 * public void adicionarCompra(Comprador comprador, Venda venda) {
	 * 
	 * comprador.adicionarCompra(venda); }
	 */

	public String retornaNomeComprador(String cpf) {

		String retorno = "Comprador";

		if (hasComprador(cpf)) {

			for (Comprador comprador : compradores) {

				if (comprador.getCpf().equals(cpf)) {

					retorno = comprador.getNome();

					break;
				}
			}
		}

		return retorno;
	}

	public String retornaCPFComprador(String cpf) {

		String retorno = "Comprador";

		if (hasComprador(cpf)) {

			for (Comprador comprador : compradores) {

				if (comprador.getCpf().equals(cpf)) {

					retorno = comprador.getCpf();

					break;
				}
			}
		}

		return retorno;
	}

	public String retornaSaldoComprador(String cpf) {

		String retorno = "Comprador";

		if (hasComprador(cpf)) {

			for (Comprador comprador : compradores) {

				if (comprador.getCpf().equals(cpf)) {

					double saldo = comprador.getSaldo();
					retorno = String.valueOf(saldo);

					break;
				}
			}
		}

		return retorno;
	}

}
