package com.curso.boundary;

import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

import com.curso.control.ControlClientes;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableView;
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
	private BorderPane painelMant;
	private HBox menuTop;
	private TextField txtNome;
	private TextField txtDia, txtMes, txtAno;
	private TextField txtRG, txtCPF;
	private TextField txtTelefone, txtEmail;
	private TextField txtCartaoSus;
	private TextField txtCEP;
	private TextField txtRua, txtNum;
	private TextField txtCid, txtUF;
	private TextField txtPesquisa;
	private TextField txtNomePesquisa;
	private TextField txtCPFPesquisa;
	private TextField txtUFPesquisa;
	private TextField txtCidadePesquisa;
	private TableView tblProb, tblCli;
	private Button btnAddProb, btnLimpaCampos, btnCadastrar, btnPesquisaProb, btnPesquisa;
	
	
	ControlClientes cc;
	
	
	@Override
	public void start(Stage stage) throws Exception{
		
		cc = new ControlClientes();
		painelCad = new Pane();
		//painelMant = new BorderPane();

//INICIO PAINEL CADASTRO-------------------------------------------------------------------------------
		
		txtNome = new TextField();
		txtDia = new TextField();
		txtMes = new TextField();
		txtAno = new TextField();
		txtRG = new TextField(); 
		txtCPF = new TextField();
		txtTelefone = new TextField();
		txtEmail = new TextField();
		txtCartaoSus = new TextField();
		
		txtCEP = new TextField();
		txtRua = new TextField();
		txtNum = new TextField();
		txtCid = new TextField();
		txtUF = new TextField();
		
		txtPesquisa = new TextField();
		
		btnLimpaCampos = new Button("LIMPAR CAMPOS");
		btnCadastrar = new Button("CADASTRAR");
		btnAddProb = new Button("ADICIONAR");
		tblProb = new TableView<Object>();
		tblProb.setMaxWidth(625);
		ImageView iv = new ImageView(new Image(new FileInputStream("imgs\\icon.png")));
		iv.setFitHeight(22);
		iv.setFitWidth(22);
		btnPesquisaProb = new Button("", iv);
		
		BorderPane pane = new BorderPane();
		
		btnCadCli = new Button("CADASTRO");
		btnMantCli = new Button("GERENCIAMENTO");
		menuTop = new HBox(btnCadCli, btnMantCli);
		
		VBox entradaInfoCli = new VBox(
				new Label("INFORMAÇÕES RELACIONADAS AO CLIENTE"),
				new Separator(),
				new HBox(10, new Label("Nome: "), txtNome),
				new HBox(10, new Label("Data Nascimento: "), txtDia, new Label("/"), txtMes, new Label("/"),txtAno),
				new HBox(10, new Label("RG: "), txtRG, new Label("CPF: "), txtCPF),
				new HBox(10, new Label("Telefone: "), txtTelefone, new Label("Email:"), txtEmail),
				new HBox(10, new Label("Cartão SUS: "), txtCartaoSus)
		);
		entradaInfoCli.setSpacing(10);
		entradaInfoCli.setStyle("-fx-min-width: 50%; -fx-font-size: 15px;");
		entradaInfoCli.setPadding(new Insets(40));
		
		VBox entradaInfoEnd = new VBox(
				new Label("INFORMAÇÕES DE ENDEREÇO"),
				new Separator(),
				new HBox(10, new Label("CEP.:"), txtCEP),
				new HBox(10, new Label("Rua:"), txtRua, new Label("Número:"), txtNum),
				new HBox(10, new Label("Cidade:"), txtCid, new Label("UF.:"), txtUF)
		);
		entradaInfoEnd.setSpacing(10);
		entradaInfoEnd.setStyle("-fx-min-width: 50%; -fx-font-size: 15px"); 
		entradaInfoEnd.setPadding(new Insets(0, 40, 40, 40));
		
		Label tituloProb = new Label("PROBLEMAS DE SAÚDE DO CLIENTE");
		tituloProb.setStyle(" -fx-font-size: 15px");
		VBox entradaTab = new VBox(
				tituloProb,
				new Separator(),
				new HBox(txtPesquisa, btnPesquisaProb),
				btnAddProb,
				tblProb
		);
		entradaTab.setPadding(new Insets(39, 40, 40, 40));
		entradaTab.setSpacing(10);
		
		HBox hbBtns = new HBox(
				btnLimpaCampos,
				btnCadastrar
		);
		hbBtns.setPadding(new Insets(7, 0, 0, 0));
		hbBtns.setStyle("-fx-min-width: 50%; -fx-font-size: 15px");
		hbBtns.setAlignment(Pos.BASELINE_CENTER);
		hbBtns.setSpacing(20);
		
		HBox entradaInfoGeral = new HBox(
				new VBox(entradaInfoCli,entradaInfoEnd, hbBtns),
				entradaTab
		);
		entradaInfoGeral.setPadding(new Insets(20, 0, 0, 0));
		
		painelCad.getChildren().add(entradaInfoGeral);

//FIM PAINEL CADASTRO----------------------------------------------------------------------------------
		
//INICIO PAINEL GERENCIAMENTO--------------------------------------------------------------------------
		
		txtNomePesquisa = new TextField();
		txtCPFPesquisa = new TextField();
		txtUFPesquisa = new TextField();
		txtCidadePesquisa = new TextField();
		btnPesquisa = new Button("PESQUISAR");
		tblCli = new TableView<Object>();
		tblCli.setMinWidth(600);
		
		Label lblTitulo = new Label("PESQUISA CLIENTE");
		HBox hb = new HBox(80,
				new VBox(10,
							lblTitulo,
							new Separator(),
							new HBox(10, new Label("Nome: "), txtNomePesquisa),
							new HBox(10, new Label("CPF.: "), txtCPFPesquisa, new Label("UF.: "), txtUFPesquisa),
							new HBox(10, new Label("Cidade: "), txtCidadePesquisa, btnPesquisa)
						),
				tblCli);
		hb.setStyle("-fx-font-size: 15px;");
		painelMant = new BorderPane(hb);
		
//FIM PAINEL GERENCIAMENTO-----------------------------------------------------------------------------
		
		pane.setTop(menuTop);
		StackPane painels = new StackPane(painelMant, painelCad);
		pane.setCenter(painels);
		
		Scene scene = new Scene(pane, 1100,600);
		stage.setScene(scene);
		stage.setTitle("Manter Clientes");
		stage.show();
		
		btnCadCli.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		btnMantCli.addEventHandler(MouseEvent.MOUSE_CLICKED, this);
		
		
		startStyle();
		btnSelected(0);
//		createTableColumns();
		
	}
	
	/*public void createTableColumnsClientes() {
		
	}*/
	
	public void startStyle() {
		
		String styleBtnPesquisa = 
				"-fx-background-color: #0095FE;"
				+ "-fx-text-fill: white;"
				+ "-fx-background-radius: 7;"
				+ "-fx-min-width: 240px;"
				+ "-fx-min-height: 30px;"
				+ "-fx-cursor: hand;";
		
		String styleBtns = 
				"-fx-background-color: #0095FE;"
				+ "-fx-text-fill: white;"
				+ "-fx-background-radius: 7;"
				+ "-fx-min-width: 275px;"
				+ "-fx-min-height: 40px;"
				+ "-fx-cursor: hand;";
		
		String styleBtnAddProb =
				"-fx-min-width: 625px;"
				+ "-fx-background-color: #007F0E;"
				+ "-fx-text-fill: white;"
				+ "-fx-font-size: 15px;"
				+ "-fx-background-radius: 8;"
				+ "-fx-cursor: hand;";
		
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
		
		String styleEntradaDataNasc = "-fx-max-width: 130px;";
		
		String styleEntradas = "-fx-background-radius: 8;";
		
		String styleEntradaPesquisa = "-fx-background-radius: 8px 0px 0px 8px;"
				+ "-fx-min-width: 587px;";
		
		String stylePesquisaProb = "-fx-min-height: 30px;"
				+ "-fx-min-width: 30px;"
				+ "-fx-background-radius: 0px 8px 8px 0px;"
				+ "-fx-background-color: #0095FE;"
				+ "-fx-cursor: hand;";
		
		btnCadCli.setStyle(styleBtn);
		btnMantCli.setStyle(styleBtn);
		painelCad.setStyle(stylePainel);
		painelMant.setStyle(stylePainel);
		menuTop.setStyle(styleMenuTop);
		txtNome.setStyle("-fx-min-width: 515px;" + styleEntradas);
		txtDia.setStyle(styleEntradaDataNasc + styleEntradas);
		txtMes.setStyle(styleEntradaDataNasc + styleEntradas);
		txtAno.setStyle(styleEntradaDataNasc + styleEntradas);
		txtRG.setStyle("-fx-min-width: 225px;" + styleEntradas);
		txtCPF.setStyle("-fx-min-width: 259px;" + styleEntradas);
		txtTelefone.setStyle("-fx-max-width: 186px;" + styleEntradas);
		txtEmail.setStyle("-fx-min-width: 253px;" + styleEntradas);
		txtCartaoSus.setStyle("-fx-min-width: 480px;" + styleEntradas);
		txtCEP.setStyle("-fx-min-width: 530px; " + styleEntradas);
		txtRua.setStyle("-fx-min-width: 228px; " + styleEntradas);
		txtNum.setStyle("-fx-min-width: 227px; " + styleEntradas);
		txtCid.setStyle("-fx-min-width: 207px; " + styleEntradas);
		txtUF.setStyle("-fx-min-width: 259px; " + styleEntradas);
		txtPesquisa.setStyle(styleEntradaPesquisa + "-fx-font-size: 15px");
		btnAddProb.setStyle(styleBtnAddProb);
		btnLimpaCampos.setStyle(styleBtns);
		btnCadastrar.setStyle(styleBtns);
		btnPesquisaProb.setStyle(stylePesquisaProb);
		txtNomePesquisa.setStyle("-fx-min-width: 515px;" + styleEntradas);
		txtCPFPesquisa.setStyle("-fx-min-width: 280px;" + styleEntradas);
		txtUFPesquisa.setStyle("-fx-min-width: 200px;" + styleEntradas);
		txtCidadePesquisa.setStyle("-fx-min-width: 262px;" + styleEntradas);
		btnPesquisa.setStyle(styleBtnPesquisa);
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
