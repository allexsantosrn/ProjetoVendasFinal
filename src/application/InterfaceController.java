package application;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Cesta;
import model.Comprador;
import model.ConsultaComprador;
import model.ConsultaProduto;
import model.ConsultaVenda;
import model.ConsultaVendedor;
import model.FormaPagamentoPIX;
import model.FormasPagamento;
import model.PagamentoBoleto;
import model.PagamentoCredito;
import model.PagamentoDebito;
import model.PagamentoTipos;
import model.Produto;
import model.Venda;
import model.Vendedor;

public class InterfaceController<T> {

	ConsultaVendedor actionVendedor = new ConsultaVendedor();
	ConsultaComprador actionComprador = new ConsultaComprador();
	ConsultaProduto actionProduto = new ConsultaProduto();
	ConsultaVenda actionVenda = new ConsultaVenda();
	Cesta cesta = new Cesta();

	double totalCompra = 0.0;
	int itensAdicionados = 0;

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

		// Criando vendedores /*
		Vendedor vendedor1 = new Vendedor("1", "Miranda Computação", 10000);
		Vendedor vendedor2 = new Vendedor("2", "Kabum Informática", 25000);
		Vendedor vendedor3 = new Vendedor("3", "Pichau Informática", 18000);
		actionVendedor.adicionarVendedor(vendedor1);
		actionVendedor.adicionarVendedor(vendedor2);
		actionVendedor.adicionarVendedor(vendedor3);

		// Criando compradores
		Comprador comprador1 = new Comprador("1", "Romário Faria", 800);
		Comprador comprador2 = new Comprador("2", "Ronaldo Nazario", 250);
		Comprador comprador3 = new Comprador("3", "Neymar Jr", 180);
		actionComprador.adicionarComprador(comprador1);
		actionComprador.adicionarComprador(comprador2);
		actionComprador.adicionarComprador(comprador3);

		// Criando produtos
		Produto produto1 = new Produto(1, "HD SSD Toshiba", 150);
		Produto produto2 = new Produto(2, "Memória RAM 2GB", 100);
		Produto produto3 = new Produto(3, "Pen Drive 4GB", 15);
		Produto produto4 = new Produto(4, "Joystick PS4", 270);
		Produto produto5 = new Produto(5, "Joystick XBOX", 450);
		Produto produto6 = new Produto(6, "Placa Mãe ASUS", 300);
		Produto produto7 = new Produto(7, "Mouse Gamer Pichau", 190);
		Produto produto8 = new Produto(8, "Gabinete Gamer", 370);
		Produto produto9 = new Produto(9, "HeadSet Gamer", 80);

		actionProduto.adicionarProduto(produto1);
		actionProduto.adicionarProduto(produto2);
		actionProduto.adicionarProduto(produto3);
		actionProduto.adicionarProduto(produto4);
		actionProduto.adicionarProduto(produto5);
		actionProduto.adicionarProduto(produto6);
		actionProduto.adicionarProduto(produto7);
		actionProduto.adicionarProduto(produto8);
		actionProduto.adicionarProduto(produto9);

		actionVendedor.adicionarItemCatalogo("1", produto1);
		actionVendedor.adicionarItemCatalogo("1", produto2);
		actionVendedor.adicionarItemCatalogo("1", produto3);
		actionVendedor.adicionarItemCatalogo("2", produto4);
		actionVendedor.adicionarItemCatalogo("2", produto5);
		actionVendedor.adicionarItemCatalogo("2", produto6);
		actionVendedor.adicionarItemCatalogo("3", produto7);
		actionVendedor.adicionarItemCatalogo("3", produto8);
		actionVendedor.adicionarItemCatalogo("3", produto9);

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
	private Label lbCPFCompradorVenda;

	@FXML
	private Label lbCodigoProdutoVenda;

	@FXML
	private Label lbQtdItensAdicionados;

	@FXML
	private Label lbCNPJVendedorVenda;

	@FXML
	private DatePicker dpVencimento;

	@FXML
	private Label lbSaldoComprador;

	@FXML
	private Label lbSaldoVendedor;

	@FXML
	private Label lbValoresComprador;

	@FXML
	private Label ldValoresVendedor;

	@FXML
	private ComboBox<PagamentoTipos> combo;

	private List<PagamentoTipos> categorias = new ArrayList<PagamentoTipos>();

	private ObservableList<PagamentoTipos> obsCategorias;

	@FXML
	void btAddItem(ActionEvent event) {

		categorias.clear();
		carregarCategorias();

		String codigoProduto = txtCodigoProduto.getText();
		String quantidade = txtQtdProduto.getText();
		String cnpj = txtCnpJVendedor.getText();
		String cpf = txtCpfComprador.getText();

		String saldoComprador = actionComprador.retornaSaldoComprador(cpf);
		String saldoVendedor = actionVendedor.retornaSaldoVendedor(cnpj);
		String valoresPagar = actionComprador.retornaValoresPagarComprador(cpf);
		String valoresReceber = actionVendedor.retornaValoresReceberVendedor(cnpj);

		int codigo = Integer.parseInt(codigoProduto);

		if (actionComprador.hasComprador(cpf)) {

			String nomeComprador = actionComprador.retornaNomeComprador(cpf);
			lbCPFCompradorVenda.setText(nomeComprador);
			lbSaldoComprador.setText(saldoComprador);
			lbValoresComprador.setText(valoresPagar);
		}

		else {

			lbCPFCompradorVenda.setText("Comprador não localizado");
		}

		if (actionVendedor.hasVendedor(cnpj)) {

			String nomeVendedor = actionVendedor.retornaNomeVendedor(cnpj);
			lbCNPJVendedorVenda.setText(nomeVendedor);
			lbSaldoVendedor.setText(saldoVendedor);
			ldValoresVendedor.setText(valoresReceber);
		}

		else {

			lbCNPJVendedorVenda.setText("Vendedor não localizado");
		}

		if (actionProduto.hasProduto(codigo)) {

			String nomeProduto = actionProduto.retornaNomeProduto(codigo);
			lbCodigoProdutoVenda.setText(nomeProduto);
		}

		else {

			lbCodigoProdutoVenda.setText("Item não localizado");
		}

		if (cesta.hasItemCesta(actionProduto.retornaProdutoByCodigo(codigo))) {

			lbStatusProduto.setText("Item já adicionado à compra.");

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Item adicionado à compra");
			alert.setHeaderText("Item já adicionado à compra");
			alert.setContentText("O item selecionado já foi adicionado à compra.");
			alert.show();

		}

		else if (actionVendedor.hasProdutoCatalogo(actionVendedor.retornaVendedorByCNPJ(cnpj), codigo)) {

			int codigoProduto2 = Integer.parseInt(codigoProduto);
			int quantidade2 = Integer.parseInt(quantidade);

			txtCpfComprador.setDisable(true);
			txtCnpJVendedor.setDisable(true);

			cesta.adicionarItemCesta(actionProduto.retornaProdutoByCodigo(codigoProduto2));

			totalCompra = totalCompra
					+ actionProduto.retornaProdutoByCodigo(codigoProduto2).getPrecoUnitario() * quantidade2;

			itensAdicionados = itensAdicionados + quantidade2;

			lbTotalCompra.setText(String.valueOf(totalCompra));
			lbQtdItensAdicionados.setText(String.valueOf(itensAdicionados));
			lbStatusProduto.setText("Item Adicionado com Sucesso!");

		}

		else {

			lbStatusProduto.setText("Item não localizado no catálogo.");

			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Item não localizado");
			alert.setHeaderText("Item não localizado");
			alert.setContentText("Item não localizado no catálogo do vendedor selecionado.");
			alert.show();
		}

	}

	@FXML
	void btConfirmarCompra(ActionEvent event) {

		String cpf = txtCpfComprador.getText();
		String cnpj = txtCnpJVendedor.getText();

		PagamentoTipos categoria = combo.getSelectionModel().getSelectedItem();

		String tipoPagamento = categoria.getFormaPagamento().getDescricao();

		LocalDate dataVencimento = dpVencimento.getValue();

		System.out.println("Tipo de Pagamento selecionado: " + tipoPagamento);

		if (!actionComprador.hasComprador(cpf)) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Comprador não localizado");
			alert.setHeaderText("Comprador não localizado");
			alert.setContentText("Não foram localizados compradores com o CPF informado.");
			alert.show();
		}

		else if (!actionVendedor.hasVendedor(cnpj)) {

			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Vendedor não localizado");
			alert.setHeaderText("Vendedor não localizado");
			alert.setContentText("Não foram localizados vendedores com o CNPJ informado.");
			alert.show();
		}

		else if (tipoPagamento == "Credito") {

			PagamentoCredito formaPagamentoCredito = new PagamentoCredito();

			formaPagamentoCredito.realizarPagamento(actionVendedor.retornaVendedorByCNPJ(cnpj),
					actionComprador.retornaCompradorByCPF(cpf), totalCompra, dataVencimento);

			Venda venda = new Venda();
			venda.setComprador(actionComprador.retornaCompradorByCPF(cpf));
			venda.setVendedor(actionVendedor.retornaVendedorByCNPJ(cnpj));
			venda.setPagamento(formaPagamentoCredito);

			actionVenda.adicionarVenda(venda);

			actionComprador.adicionarCompra(actionComprador.retornaCompradorByCPF(cpf), venda);
			actionVendedor.adicionarVenda(actionVendedor.retornaVendedorByCNPJ(cnpj), venda);

			alertaSucesso();
			clearCamposVenda();
		}

		else if (tipoPagamento == "PIX") {

			FormaPagamentoPIX formaPagamento = new FormaPagamentoPIX();

			if (formaPagamento.checarFundos(actionComprador.retornaCompradorByCPF(cpf), totalCompra)) {

				formaPagamento.realizarPagamento(actionVendedor.retornaVendedorByCNPJ(cnpj),
						actionComprador.retornaCompradorByCPF(cpf), totalCompra, dataVencimento);

				Venda venda = new Venda();
				venda.setComprador(actionComprador.retornaCompradorByCPF(cpf));
				venda.setVendedor(actionVendedor.retornaVendedorByCNPJ(cnpj));
				venda.setPagamento(formaPagamento);

				actionVenda.adicionarVenda(venda);

				actionComprador.adicionarCompra(actionComprador.retornaCompradorByCPF(cpf), venda);
				actionVendedor.adicionarVenda(actionVendedor.retornaVendedorByCNPJ(cnpj), venda);

				alertaSucesso();
				clearCamposVenda();

			}

			else {

				alertaNoFunds();
			}

		}

		else if (tipoPagamento == "Debito") {

			PagamentoDebito formaPagamentoDebito = new PagamentoDebito();

			if (formaPagamentoDebito.checarFundos(actionComprador.retornaCompradorByCPF(cpf), totalCompra)) {

				formaPagamentoDebito.realizarPagamento(actionVendedor.retornaVendedorByCNPJ(cnpj),
						actionComprador.retornaCompradorByCPF(cpf), totalCompra, dataVencimento);

				Venda venda = new Venda();
				venda.setComprador(actionComprador.retornaCompradorByCPF(cpf));
				venda.setVendedor(actionVendedor.retornaVendedorByCNPJ(cnpj));
				venda.setPagamento(formaPagamentoDebito);

				actionVenda.adicionarVenda(venda);

				actionComprador.adicionarCompra(actionComprador.retornaCompradorByCPF(cpf), venda);
				actionVendedor.adicionarVenda(actionVendedor.retornaVendedorByCNPJ(cnpj), venda);

				alertaSucesso();
				clearCamposVenda();

			}

			else {

				alertaNoFunds();
			}
		}

		else {

			PagamentoBoleto formaPagamentoBoleto = new PagamentoBoleto();

			if (formaPagamentoBoleto.checarFundos(actionComprador.retornaCompradorByCPF(cpf), totalCompra)) {

				LocalDate dataPagamento = LocalDate.now();

				System.out.println("Data de Pagamento: " + dataPagamento);

				System.out.println("Data de Vencimento: " + dataVencimento);

				if (formaPagamentoBoleto.isVencido(dataPagamento, dataVencimento)) {

					alertaVencimento();

				}

				else {

					formaPagamentoBoleto.realizarPagamento(actionVendedor.retornaVendedorByCNPJ(cnpj),
							actionComprador.retornaCompradorByCPF(cpf), totalCompra, dataVencimento);

					Venda venda = new Venda();
					venda.setComprador(actionComprador.retornaCompradorByCPF(cpf));
					venda.setVendedor(actionVendedor.retornaVendedorByCNPJ(cnpj));
					venda.setPagamento(formaPagamentoBoleto);

					actionVenda.adicionarVenda(venda);

					actionComprador.adicionarCompra(actionComprador.retornaCompradorByCPF(cpf), venda);
					actionVendedor.adicionarVenda(actionVendedor.retornaVendedorByCNPJ(cnpj), venda);

					alertaSucesso();
					clearCamposVenda();

				}
			}

			else {

				alertaNoFunds();
			}
		}

	}

	@FXML
	void btLimparCarrinho(ActionEvent event) {

		cesta.removerCesta();
		lbQtdItensAdicionados.setText("");
		lbTotalCompra.setText("");
		totalCompra = 0.0;
		itensAdicionados = 0;
		lbStatusProduto.setText("");
		txtQtdProduto.setText("");
		txtCodigoProduto.setText("");

	}

	@FXML
	void btReiniciar(ActionEvent event) {

		clearCamposVenda();

	}

	@FXML
	void btVoltarVenda(ActionEvent event) {

		clearCamposVenda();
		Main.changedScreen("secundary");
	}

	public void alertaNoFunds() {

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Não há fundos");
		alert.setHeaderText("Não há recursos disponíveis");
		alert.setContentText("Não há fundos suficientes para realização da compra.");
		alert.show();
	}

	public void alertaSucesso() {

		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Compra confirmada");
		alert.setHeaderText("Compra realizada com sucesso");
		alert.setContentText("A compra foi realizada com sucesso.");
		alert.show();

	}

	public void alertaVencimento() {

		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Boleto vencido");
		alert.setHeaderText("Pagamento além da data de vencimento");
		alert.setContentText("Boleto vencido. Não é possível realizar pagamento.");
		alert.show();

	}

	public void clearCamposVenda() {

		cesta.removerCesta();
		txtCpfComprador.setDisable(false);
		txtCnpJVendedor.setDisable(false);
		totalCompra = 0.0;
		itensAdicionados = 0;
		lbTotalCompra.setText("");
		lbStatusProduto.setText("");
		txtCpfComprador.setText("");
		txtCnpJVendedor.setText("");
		txtCodigoProduto.setText("");
		txtQtdProduto.setText("");
		lbQtdItensAdicionados.setText("");
		lbCNPJVendedorVenda.setText("");
		lbCPFCompradorVenda.setText("");
		lbSaldoComprador.setText("");
		lbSaldoVendedor.setText("");
		ldValoresVendedor.setText("");
		lbValoresComprador.setText("");
		lbCodigoProdutoVenda.setText("");
		dpVencimento.setValue(null);
		combo.getSelectionModel().clearSelection();
		combo.getItems().clear();
		categorias.clear();

	}

	public void carregarCategorias() {

		PagamentoTipos categoria1 = new PagamentoTipos(1, FormasPagamento.PIX);
		PagamentoTipos categoria2 = new PagamentoTipos(2, FormasPagamento.BOLETO);
		PagamentoTipos categoria3 = new PagamentoTipos(3, FormasPagamento.CREDITO);
		PagamentoTipos categoria4 = new PagamentoTipos(4, FormasPagamento.DEBITO);

		categorias.add(categoria1);
		categorias.add(categoria2);
		categorias.add(categoria3);
		categorias.add(categoria4);

		obsCategorias = FXCollections.observableArrayList(categorias);

		combo.setItems(obsCategorias);
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
