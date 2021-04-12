package model;

public class PagamentoTipos {

	int id;
	FormasPagamento formaPagamento;

	public PagamentoTipos(int id, FormasPagamento formaPagamento) {
		this.id = id;
		this.formaPagamento = formaPagamento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FormasPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormasPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	@Override
	public String toString() {
		return ""+this.formaPagamento+"";
	}
	
	

}
