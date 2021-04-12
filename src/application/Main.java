package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class Main extends Application {

	private static Stage stage;

	private static Scene mainScene;
	private static Scene secundaryScene;
	private static Scene searchVendedorScene;
	private static Scene salesScene;
	private static Scene searchCompradorScene;
	private static Scene searchProdutoScene;

	@Override
	public void start(Stage primaryStage) throws Exception {

		stage = primaryStage;

		primaryStage.setTitle("Main");

		Parent fxmlMain = FXMLLoader.load(getClass().getResource("/view/tela_principal.fxml"));
		mainScene = new Scene(fxmlMain, 640, 400);

		Parent fxmlDetails = FXMLLoader.load(getClass().getResource("/view/tela_secundaria.fxml"));
		secundaryScene = new Scene(fxmlDetails, 640, 400);
		
		Parent fxmlDetails2 = FXMLLoader.load(getClass().getResource("/view/consulta_vendedor.fxml"));
		searchVendedorScene = new Scene(fxmlDetails2, 640, 400);

		Parent fxmlDetails3 = FXMLLoader.load(getClass().getResource("/view/cadastro_venda.fxml"));
		salesScene = new Scene(fxmlDetails3, 650, 400);

		Parent fxmlDetails4 = FXMLLoader.load(getClass().getResource("/view/consulta_comprador.fxml"));
		searchCompradorScene = new Scene(fxmlDetails4, 640, 400);

		Parent fxmlDetails5 = FXMLLoader.load(getClass().getResource("/view/consulta_produto.fxml"));
		searchProdutoScene = new Scene(fxmlDetails5, 640, 400);

		primaryStage.setScene(mainScene);
		primaryStage.show();

	}

	public static void changedScreen(String scr) {

		switch (scr) {
		case "main":
			stage.setScene(mainScene);
			break;
		case "secundary":
			stage.setScene(secundaryScene);
			break;
		case "searchvendedor":
			stage.setScene(searchVendedorScene);
			break;
		case "sales":
			stage.setScene(salesScene);
			break;
		case "searchcomprador":
			stage.setScene(searchCompradorScene);
			break;
		case "searchproduto":
			stage.setScene(searchProdutoScene);
			break;
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
