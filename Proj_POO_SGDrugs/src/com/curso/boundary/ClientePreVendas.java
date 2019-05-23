package com.curso.boundary;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientePreVendas extends Application implements EventHandler<MouseEvent>{
	// Paineis Realizar Vendas(RV) InfoCliente(IC), Grid
	private Pane PaneRV,PaneIC;
	private GridPane panegrid;
	// box´s verticais / horizontais
	private VBox btnAvancarInfo,RV,IC,Infos;
	private HBox btnsRV;
	// realizar venda
	private TextField cpfCliente;
	private Button btnPesquisar,btnAvancar;
	private Label RealVendas,InfoAvancar;
	// info cliente
	private Label InfoCliente,nameClient,cpfClient,idadeClient,sexClient;
	private Label ruaClient,nClient,bairroClient;
	private Button btnAvancarSDef;
	@Override
	public void start(Stage stgPreV) throws Exception {
		// Box REALIZAR VENDA
		RealVendas 			= new Label("REALIZAR VENDA");
		cpfCliente 			= new TextField();
		cpfCliente.setPromptText("Insira o CPF do Cliente");//Funciona como um placeholder
		btnPesquisar 		= new Button("PESQUISAR");
		btnAvancar 			= new Button("AVANÇAR");
		InfoAvancar 		= new Label("Necessario definir um Cliente");
		// Box Info Cliente
		InfoCliente 		= new Label("INFO. CLIENTE");
		nameClient 			= new Label();
		cpfClient 			= new Label();
		idadeClient 		= new Label();
		sexClient 			= new Label();
		ruaClient 			= new Label();
		nClient 			= new Label();
		bairroClient 		= new Label();
		btnAvancarSDef 		= new Button("AVANÇAR SEM DEFINIR CLIENTE");
		// Paineis Realizar Venda, Informação Cliente e o grid
		panegrid 			= new GridPane();
		PaneRV 				= new Pane();
		PaneIC 				= new Pane();
		// Adicionando no grid os dois paineis
		panegrid.add(PaneRV, 1,0);
		panegrid.add(PaneIC, 2,0);
//													INICIO REALIZAR VENDAS

		btnAvancarInfo 		= new VBox(btnAvancar,InfoAvancar);
		btnsRV 				= new HBox(btnPesquisar,btnAvancarInfo);
		RV 					= new VBox(RealVendas,new Separator(),cpfCliente,btnsRV);
		PaneRV.getChildren().add(RV);
		
//													FIM REALIZAR VENDAS
		
//													INICIO INFORMAÇÃO CLIENTE
		
		Infos 				= new VBox(new HBox(10,new Label("Nome: "),nameClient)
				        	 ,new HBox(10,new Label("CPF: "),cpfClient)
				  	         ,new HBox(10,new Label("Idade: "),idadeClient
				  				         ,new Label(" Sexo: "),sexClient)
				  	         ,new HBox(10,new Label("Endereço: "),ruaClient
				  	         ,new Label(", n°"),nClient
				  	         ,new Label(" "),bairroClient));
		IC 					= new VBox(InfoCliente,new Separator(),Infos,btnAvancarSDef);
		PaneIC.getChildren().add(IC);
		
//													FIM INFORMAÇÃO CLIENTE
		
		Styles();
		Scene MainScene 	= new Scene(panegrid, 900,380);
		stgPreV.setScene(MainScene);
		stgPreV.setTitle("Seleção de Cliente - Pré Tela de Vendas");
		stgPreV.show();
	}
	
	public void Styles() {
		// styles
			//									STYLE REALIZAR VENDA
				PaneRV.setPrefWidth(600);
				btnsRV.setStyle("-fx-min-width: 50%; -fx-font-size: 15px");
				btnsRV.setAlignment(Pos.BASELINE_CENTER);
				btnsRV.setSpacing(30);
				RV.setPadding(new Insets(35));
				RV.setStyle("-fx-font-family:'Arial';");
				RV.setAlignment(Pos.BASELINE_CENTER);
				RV.setSpacing(10);
				
				RealVendas.setStyle("-fx-font-size: 40px;");
				RealVendas.setPadding(new Insets(20,0,0,0));
				cpfCliente.setStyle("-fx-min-width:500px;"+
								    "-fx-min-height:35px;"+
								    "-fx-font-size:15px;");
				btnPesquisar.setStyle("-fx-background-color:#00BFFF;"+
									  "-fx-background-radius:8px;"+
									  "-fx-min-width:250px;"+
									  "-fx-min-height:35px;"+
									  "-fx-font-size:15px;"+
									  "-fx-text-fill: white;"+
									  "-fx-border-radius:8px;");
				btnAvancar.setStyle("-fx-background-color:#228B22;"+
									"-fx-background-radius:8px;"+
									"-fx-min-width:250px;"+
									"-fx-min-height:35px;"+
									"-fx-font-size:15px;"+
									"-fx-text-fill: white;"+
									"-fx-border-radius:8px;");
				InfoAvancar.setStyle("-fx-font-size:12px;");
		   //				                    STYLE INFORMAÇÃO CLIENTE
				PaneIC.setPrefWidth(300);
				Infos.setPadding(new Insets(20,0,56,20));
				Infos.setSpacing(25);
				IC.setStyle("-fx-background-color:#EEE5DE;"+
							"-fx-font-family:'Arial';"+
							"-fx-font-size:15;");
				IC.setMinHeight(400);
				IC.setSpacing(20);
				InfoCliente.setStyle("-fx-font-size:24px;");
				InfoCliente.setPadding(new Insets(20,0,0,60));
				btnAvancarSDef.setStyle("-fx-background-color:#228B22;"+
										"-fx-min-width:300px;"+
										"-fx-min-height:50px;"+
									    "-fx-font-size: 15px;"+
										"-fx-text-fill: white;");
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
	@Override
	public void handle(MouseEvent event) {
		
	}
}
