package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {
	
	@FXML
	protected void btIniciar(ActionEvent e) {
		
		System.out.println("Programa Iniciado!!");
		
		Main.changedScreen("secundary");
	}
}
