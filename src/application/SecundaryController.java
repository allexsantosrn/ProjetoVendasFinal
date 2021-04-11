package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SecundaryController {
		
	@FXML
    void btCadastroVenda(ActionEvent event) {
    		    	
    	Main.changedScreen("sales");
    }
	
	@FXML
	protected void btConsultaVendedor(ActionEvent e) {
		
		Main.changedScreen("searchvendedor");
	}
		  
	@FXML
	protected void btConsultaComprador(ActionEvent e) {
		
		Main.changedScreen("searchcomprador");
	}
	
	@FXML
	protected void btConsultaProduto(ActionEvent e) {
		
		Main.changedScreen("searchproduto");
	}
   


}
