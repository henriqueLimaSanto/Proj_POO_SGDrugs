package com.curso.boundary;

import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ManterCliente extends Application implements EventHandler<MouseEvent>{

	private Button btnCadCli;
	private Button btnMantCli;
	private Pane painelCad;
	private Pane painelMant;
	private HBox menuTop;
	private TextField txtNome;
	private TextField txtDia, txtMes, txtAno;
	private TextField txtRG, txtCPF;
	private TextField txtTelefone, txtEmail;
	private TextField txtCartaoSus;
	
	
	@Override
	public void start(Stage stage) throws Exception{
		
		txtNome = new TextField();
		txtDia = new TextField();
		txtMes = new TextField();
		txtAno = new TextField();
		txtRG = new TextField(); 
		txtCPF = new TextField();
		txtTelefone = new TextField();
		txtEmail = new TextField();
		txtCartaoSus = new TextField();
		
		BorderPane pane = new BorderPane();
		
		btnCadCli = new Button("CADASTRO");
		btnMantCli = new Button("GERENCIAMENTO");
		menuTop = new HBox(btnCadCli, btnMantCli);
		pane.setTop(menuTop);
		
		
		painelCad = new Pane();
		painelMant = new Pane();
		StackPane painels = new StackPane(painelMant, painelCad);
		pane.setCenter(painels);
		
		VBox entradaInfoCli = new VBox(
				new Label("INFORMAÇÕES RELACIONADAS AO CLIENTE"),
				new HBox(10, new Label("Nome: "), txtNome),
				new HBox(10, new Label("Data Nascimento: "), txtDia, new Label("/"), txtMes, new Label("/"),txtAno),
				new HBox(10, new Label("RG: "), txtRG, new Label("CPF: "), txtCPF),
				new HBox(10, new Label("Telefone: "), txtTelefone, new Label("Email:"), txtEmail),
				new HBox(10, new Label("Cartão SUS: "), txtCartaoSus)
		);
		entradaInfoCli.setSpacing(10);
		entradaInfoCli.setStyle("-fx-min-width: 50%; -fx-font-size: 12px");
		HBox entradaInfoCliGeral = new HBox(entradaInfoCli);
		entradaInfoCli.setPadding(new Insets(40));
		
		
		painelCad.getChildren().add(entradaInfoCli);
		
		Scene scene = new Scene(pane, 1100,600);
		stage.setScene(scene);
		stage.setTitle("Manter Clientes");
		stage.show();
		
		btnCadCli.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		btnMantCli.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		
		startStyle();
		btnSelected(0);
		
	}
	
	public void startStyle() {
		String styleBtn =
				"-fx-background-radius: none;"
				+ "-fx-min-width: 130px;"
				+ "-fx-min-height: 40px;"
				+ "-fx-cursor: hand;"
				+ "-fx-font-color: #545452;"
				+ "-fx-font-weight: bold;";
		
		String stylePainel = 
				"-fx-background-color: #FEFFFA;"
				+ "-fx-padding: 50, 50, 50, 50;";
		
		String styleMenuTop = "-fx-background-color: #E0DACE";
		
		String styleEntradaDataNasc = "-fx-max-width: 100px;";
		
		String styleEntradas = "-fx-background-radius: 8;";
		
		btnCadCli.setStyle(styleBtn);
		btnMantCli.setStyle(styleBtn);
		painelCad.setStyle(stylePainel);
		painelMant.setStyle(stylePainel);
		menuTop.setStyle(styleMenuTop);
		txtNome.setStyle("-fx-min-width: 409px;" + styleEntradas);
		txtDia.setStyle(styleEntradaDataNasc + styleEntradas);
		txtMes.setStyle(styleEntradaDataNasc + styleEntradas);
		txtAno.setStyle(styleEntradaDataNasc + styleEntradas);
		txtRG.setStyle("-fx-min-width: 190px;" + styleEntradas);
		txtCPF.setStyle("-fx-min-width: 190px;" + styleEntradas);
		txtTelefone.setStyle("-fx-min-width: 160px;" + styleEntradas);
		txtEmail.setStyle("-fx-min-width: 185px;" + styleEntradas);
		txtCartaoSus.setStyle("-fx-min-width: 381px;" + styleEntradas);
	}
	
	public void btnSelected(int btn) {
		String CadSelected = "";
		String MantSelected = "";
		if(btn == 0) {
			CadSelected = "#FEFFFA";
			MantSelected = "#EAEAEA";
		}else {
			CadSelected = "#EAEAEA";
			MantSelected = "#FEFFFA";
		}
		btnCadCli.setStyle(
				"-fx-background-color: " + CadSelected + ";"
				+ "-fx-background-radius: none;"
				+ "-fx-min-width: 130px;"
				+ "-fx-min-height: 40px;"
				+ "-fx-cursor: hand;"
		);
		btnMantCli.setStyle(
				"-fx-background-color: " + MantSelected + ";"
				+ "-fx-background-radius: none;"
				+ "-fx-min-width: 130px;"
				+ "-fx-min-height: 40px;"
				+ "-fx-cursor: hand;"
		);
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void handle(MouseEvent e) {
		if(e.getSource() == btnCadCli) {
			//System.out.println("teste");
			painelCad.toFront();
			btnSelected(0);
		}else
		if(e.getSource() == btnMantCli) {
			painelMant.toFront();
			btnSelected(1);
		}
	}

}
