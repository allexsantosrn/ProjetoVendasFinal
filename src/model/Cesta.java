package model;

import java.util.Collection;
import java.util.HashSet;

public class Cesta {

	private Collection<Produto> itens = new HashSet<>();
	
	public void adicionarItemCesta(Produto produto) {
		itens.add(produto);
	}
	
	public boolean hasItemCesta (Produto produto) {
		
		boolean existe = false;
		
		if (itens.contains(produto)) {
			existe = true;
			System.out.println("");
			System.out.println("Já existe um produto com o código informado nesta compra.");
			System.out.println("");
		}
		
		return existe;
		
	}
	
	public void removerCesta() {		
		itens.clear();
	}
	
	
}
