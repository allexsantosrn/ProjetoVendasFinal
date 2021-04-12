package model;

public enum FormasPagamento {	
	
	PIX("PIX"), DEBITO("Debito"), CREDITO("Credito"), BOLETO("Boleto");
	
	private String descricao;
	
	FormasPagamento(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

}
