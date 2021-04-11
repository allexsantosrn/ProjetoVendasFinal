package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Comprador;
import model.ConsultaComprador;
import model.ConsultaProduto;
import model.ConsultaVenda;
import model.ConsultaVendedor;
import model.FormaPagamentoPIX;
import model.Produto;
import model.Venda;
import model.Vendedor;

public class InterfaceController {

	ConsultaVendedor actionVendedor = new ConsultaVendedor();
	ConsultaComprador actionComprador = new ConsultaComprador();
	ConsultaProduto actionProduto = new ConsultaProduto();
	ConsultaVenda actionVenda = new ConsultaVenda();
	Venda venda = new Venda();

	double totalCompra = 0.0;

	@FXML
	private Label lbVendedor;

	@FXML
	private Label lbVendedorCnpj;

	@FXML
	private Label lbVendedorNome;

	@FXML
	private Label lbVendedorSaldo;

	@FXML
	private TextField txtConsultaVendedor;

	@FXML
	public void initialize() {

		initData();
	}

	public void initData() {

		// Criando vendedores
		Vendedor vendedor1 = new Vendedor("1", "Miranda Computação", 10000);
		Vendedor vendedor2 = new Vendedor("2", "Kabum Informática", 25000);
		Vendedor vendedor3 = new Vendedor("3", "Pichau Informática", 18000);
		actionVendedor.adicionarVendedor(vendedor1);
		actionVendedor.adicionarVendedor(vendedor2);
		actionVendedor.adicionarVendedor(vendedor3);

		// Criando compradores
		Comprador comprador1 = new Comprador("1", "Romário de Souza Faria", 800);
		Comprador comprador2 = new Comprador("2", "Ronaldo Nazario", 250);
		Comprador comprador3 = new Comprador("3", "Neymar Pereira", 180);
		actionComprador.adicionarComprador(comprador1);
		actionComprador.adicionarComprador(comprador2);
		actionComprador.adicionarComprador(comprador3);

		// Criando produtos
		Produto produto1 = new Produto(1, "HD SSD Toshiba", 150);
		Produto produto2 = new Produto(2, "Memória RAM Kingston", 100);
		Produto produto3 = new Produto(3, "Pen Drive 4GB", 15);
		actionProduto.adicionarProduto(produto1);
		actionProduto.adicionarProduto(produto2);
		actionProduto.adicionarProduto(produto3);

		actionVendedor.adicionarItemCatalogo("1", produto1);
		actionVendedor.adicionarItemCatalogo("2", produto2);
		actionVendedor.adicionarItemCatalogo("3", produto3);
	}

	public void clearCamposVendedor() {
		lbVendedor.setText("");
		lbVendedorCnpj.setText("");
		lbVendedorNome.setText("");
		lbVendedorSaldo.setText("");

	}

	@FXML
	void btConsultaVendedor(ActionEvent event) {

		String cnpj = txtConsultaVendedor.getText();

		if (actionVendedor.hasVendedor(cnpj)) {

			String cnpj2 = actionVendedor.retornaCNPJVendedor(cnpj);
			String nome = actionVendedor.retornaNomeVendedor(cnpj);
			String saldo = actionVendedor.retornaSaldoVendedor(cnpj);

			lbVendedor.setText("Vendedor localizado!");
			lbVendedorCnpj.setText("CNPJ: " + cnpj2);
			lbVendedorNome.setText("Nome: " + nome);
			lbVendedorSaldo.setText("Saldo Inicial: " + saldo);
		}

		else {

			clearCamposVendedor();
			lbVendedor.setText("Vendedor não localizado!");
		}

	}

	@FXML
	void btVoltar(ActionEvent event) {

		clearCamposVendedor();
		txtConsultaVendedor.setText("");
		Main.changedScreen("secundary");
	}

	@FXML
	private TextField txtCpfComprador;

	@FXML
	private TextField txtCnpJVendedor;

	@FXML
	private TextField txtCodigoProduto;

	@FXML
	private Label lbQtdProduto;

	@FXML
	private TextField txtQtdProduto;

	@FXML
	private Label lbStatusProduto;

	@FXML
	private Label lbTotalCompra;

	@FXML
	void btAddItem(ActionEvent event) {

		String codigoProduto = txtCodigoProduto.getText();
		String quantidade = txtQtdProduto.getText();

		int codigoProduto2 = Integer.parseInt(codigoProduto);
		int quantidade2 = Integer.parseInt(quantidade);
		
		

		totalCompra = totalCompra
				+ actionProduto.retornaProdutoByCodigo(codigoProduto2).getPrecoUnitario() * quantidade2;

		lbTotalCompra.setText(String.valueOf(totalCompra));
		lbStatusProduto.setText("Item Adicionado com Sucesso");
	}

	@FXML
	void btConfirmarCompra(ActionEvent event) {

		String cpf = txtCpfComprador.getText();
		String cnpj = txtCnpJVendedor.getText();

		FormaPagamentoPIX formaPagamento = new FormaPagamentoPIX();

		formaPagamento.realizarPagamento(actionVendedor.retornaVendedorByCNPJ(cnpj),
				actionComprador.retornaCompradorByCPF(cpf), totalCompra);

		
		venda.setComprador(actionComprador.retornaCompradorByCPF(cpf));
		venda.setVendedor(actionVendedor.retornaVendedorByCNPJ(cnpj));
		venda.setPagamento(formaPagamento);

	}

	@FXML
	void btVoltarVenda(ActionEvent event) {

		Main.changedScreen("secundary");
	}

	@FXML
	private TextField txtConsultaComprador;

	@FXML
	private Label lbComprador;

	@FXML
	private Label lbCompradorCpf;

	@FXML
	private Label lbCompradorNome;

	@FXML
	private Label lbCompradorSaldo;

	@FXML
	void btConsultaComprador(ActionEvent event) {

		String cpf = txtConsultaComprador.getText();

		if (actionComprador.hasComprador(cpf)) {

			String cpf2 = actionComprador.retornaCPFComprador(cpf);
			String nome = actionComprador.retornaNomeComprador(cpf);
			String saldo = actionComprador.retornaSaldoComprador(cpf);

			lbComprador.setText("Comprador localizado!");
			lbCompradorCpf.setText("CPF: " + cpf2);
			lbCompradorNome.setText("Nome: " + nome);
			lbCompradorSaldo.setText("Saldo Inicial: " + saldo);
		}

		else {

			clearCamposComprador();
			lbComprador.setText("Comprador não localizado!");
		}
	}

	public void clearCamposComprador() {

		lbComprador.setText("");
		lbCompradorCpf.setText("");
		lbCompradorNome.setText("");
		lbCompradorSaldo.setText("");
	}

	@FXML
	void btVoltar2(ActionEvent event) {

		clearCamposComprador();
		txtConsultaComprador.setText("");
		Main.changedScreen("secundary");
	}

	@FXML
	private TextField txtConsultaProduto;

	@FXML
	private Label lbProduto;

	@FXML
	private Label lbProdutoCodigo;

	@FXML
	private Label lbProdutoNome;

	@FXML
	private Label lbProdutoValor;

	@FXML
	void btConsultaProduto(ActionEvent event) {

		String codigo = txtConsultaProduto.getText();

		int codigo2 = Integer.parseInt(codigo);

		if (actionComprador.hasComprador(codigo)) {

			String codigofinal = actionProduto.retornaCodigoProduto(codigo2);
			String nome = actionProduto.retornaNomeProduto(codigo2);
			String valor = actionProduto.retornaPrecoProduto(codigo2);

			lbProduto.setText("Produto localizado!");
			lbProdutoCodigo.setText("Código: " + codigofinal);
			lbProdutoNome.setText("Nome: " + nome);
			lbProdutoValor.setText("Preço Unitário: " + valor);
		}

		else {

			clearCamposProduto();
			lbProduto.setText("Comprador não localizado!");
		}
	}

	public void clearCamposProduto() {

		lbProduto.setText("");
		lbProdutoCodigo.setText("");
		lbProdutoNome.setText("");
		lbProdutoValor.setText("");
	}

	@FXML
	void btVoltar3(ActionEvent event) {

		clearCamposProduto();
		txtConsultaProduto.setText("");
		Main.changedScreen("secundary");
	}

}
