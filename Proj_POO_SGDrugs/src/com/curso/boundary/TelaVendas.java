package com.curso.boundary;
import java.io.FileInputStream;
import com.curso.control.ControlVendas;
import com.curso.entity.ItemVenda;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaVendas extends Application implements EventHandler<MouseEvent> {
	private Pane painelVenda;
	private Pane painelPosVenda;
	private Button btnPesquisar;
	private Button btnAdicionar;
	private Button btnFinalizar;
	private Label lblValorUnt;
	private Label lblQuantidade;
	private Label lblTotal;
	private Label lblVenda;
	private Label lblCompra;
	private CheckBox cbCartaoCredito;
	private CheckBox cbCartaoDebito;
	private CheckBox cbDinheiro;
	private TextField txtPesquisa;
	private TextField txtQuantidade;
	private TableView<ItemVenda> tblItens;

	ControlVendas cv;

	@Override
	public void start(Stage stage) throws Exception {

		painelVenda = new Pane();
		BorderPane pane = new BorderPane();

		lblCompra = new Label("COMPRA");
		lblCompra.setStyle("-fx-font-size: 35px;");
		lblCompra.setPrefSize(170, 50);
		lblCompra.relocate(1040, 40);

		lblVenda = new Label("ITENS DA VENDA");
		lblVenda.setStyle("-fx-font-size: 35px;");
		lblVenda.setPrefSize(270, 50);
		lblVenda.relocate(270, 40);

		lblTotal = new Label("TOTAL: R$0,00");
		lblTotal.setMaxSize(200, 40);
		lblTotal.setStyle("-fx-font-size: 30px;");
		lblTotal.relocate(270, 600);

		lblValorUnt = new Label("preço unitáro: R$: 0,00");
		lblQuantidade = new Label("Qtd. total no estoque: 0");

		ImageView iv = new ImageView(new Image(new FileInputStream("imgs\\search.png")));
		iv.setFitHeight(20);
		iv.setFitWidth(20);

		btnPesquisar = new Button("", iv);
		btnPesquisar.setPrefSize(30, 25);

		btnAdicionar = new Button("ADICIONAR");
		btnAdicionar.setPrefSize(140, 25);

		btnFinalizar = new Button("FINALIZAR COMPRA");
		btnFinalizar.setPrefSize(425, 70);

		txtPesquisa = new TextField();
		txtPesquisa.setPrefSize(200, 25);
		txtPesquisa.setPromptText("codigo ou descrição");

		txtQuantidade = new TextField();
		txtQuantidade.setPrefSize(190, 25);
		txtQuantidade.setPromptText("insira a quantidade");

		cbCartaoCredito = new CheckBox("cartão de crédito");
		cbCartaoDebito = new CheckBox("cartão de débito");
		cbDinheiro = new CheckBox("dinheiro");

		tblItens = new TableView<ItemVenda>();
		tblItens.setPrefWidth(600);
		tblItens.setPrefHeight(400);

		createTableColumnsProb();

		StackPane painels = new StackPane(painelVenda);
		pane.setCenter(painels);

		VBox entradaProduto = new VBox(new Label("Adicionar Produto"), new Separator(),
				new HBox(10, txtPesquisa, btnPesquisar), new HBox(10, txtQuantidade, btnAdicionar),
				new HBox(10, lblValorUnt), new HBox(10, lblQuantidade));
		entradaProduto.setPadding(new Insets(120, 60, 50, 20));
		entradaProduto.setSpacing(10);
		entradaProduto.setStyle("-fx-min-width: 50%; -fx-font-size: 15px; ");

		VBox formaPagamento = new VBox(new Label("Forma de Pagamento"), new Separator(), new HBox(10, cbCartaoCredito),
				new HBox(10, cbCartaoDebito), new HBox(10, cbDinheiro));
		formaPagamento.setPadding(new Insets(20, 60, 40, 20));
		formaPagamento.setSpacing(10);
		formaPagamento.setStyle("-fx-min-width: 50%; -fx-font-size: 15px; ");

		VBox finalizar = new VBox(new HBox(40, btnFinalizar));
		finalizar.setPadding(new Insets(80, 0, 0, 0));
		finalizar.setStyle("-fx-min-width: 50%; -fx-font-size: 15px; ");

		VBox entradaItens = new VBox(new HBox(tblItens));
		entradaItens.setPadding(new Insets(140, 0, 100, 50));

		HBox HCompra = new HBox(new VBox(entradaProduto, formaPagamento, finalizar));
		HCompra.setStyle("-fx-background-color: #E3E8EE;");
		HCompra.setPadding(new Insets(0, 50, 100, 50));

		HBox HItens = new HBox(new VBox(entradaItens));
		HItens.setStyle("-fx-background-color: rgb(242,242,242)");
		HItens.setPadding(new Insets(0, 100, 100, 50));

		HBox geral = new HBox(new VBox(HItens), new VBox(HCompra));
		geral.setPadding(new Insets(0, 1300, 50, 0));
		geral.setSpacing(50);
		geral.setStyle("-fx-background-color: rgb(237,237,237);");

		painelVenda.getChildren().addAll(geral, lblCompra, lblVenda, lblTotal);

		Scene scene = new Scene(pane, 1360, 700);
		stage.setScene(scene);
		stage.setTitle("Controle de Vendas");
		stage.show();

		loadStyles();

	}

	public void loadStyles() {

		String stylePainelVendas = "-fx-background-color:white;" + "-fx-padding: 50, 50, 50, 50";

		String styleEntradas = "-fx-background-radius: 8;";

		String styleBtnAdd = "-fx-background-color: #0095FE;" + "-fx-text-fill: white;";

		String styleBtnFinaliza = "-fx-background-color: #007F0E;" + "-fx-text-fill: white;";

		btnPesquisar.setStyle(styleBtnAdd);
		btnAdicionar.setStyle(styleBtnAdd);
		btnFinalizar.setStyle(styleBtnFinaliza);
		painelVenda.setStyle(stylePainelVendas);
		txtPesquisa.setStyle(styleEntradas + "-fx-font-size: 15px;");
		txtQuantidade.setStyle(styleEntradas + "-fx-font-size: 15px");

	}

	public void createTableColumnsProb() {
		
		TableColumn<ItemVenda, Number> id_produto = new TableColumn<>("ID");
		id_produto.setCellValueFactory(
				item -> new ReadOnlyIntegerWrapper(item.getValue().getProduto().getProduto().getId_produto()));

		TableColumn<ItemVenda, String> desc_produto = new TableColumn<>("Descrição");
		desc_produto.setCellValueFactory(
				item -> new ReadOnlyStringWrapper(item.getValue().getProduto().getProduto().getNome()));

		TableColumn<ItemVenda, Number> valor_produto = new TableColumn<>("Preço");
		valor_produto.setCellValueFactory(item -> new ReadOnlyDoubleWrapper(item.getValue().getProduto().getPreco()));

		TableColumn<ItemVenda, Number> quant_produto = new TableColumn<>("Quant.");
		quant_produto.setCellValueFactory(item -> new ReadOnlyIntegerWrapper(item.getValue().getQntd()));

		TableColumn<ItemVenda, Number> sub_total = new TableColumn<>("Subtotal");
		sub_total.setCellValueFactory(
				item -> new ReadOnlyDoubleWrapper(item.getValue().getProduto().getPreco() * item.getValue().getQntd()));

		tblItens.getColumns().addAll(id_produto, desc_produto, valor_produto, quant_produto, sub_total);
	}

	public void loadButtons() {

	}

	public static void main(String[] args) {

		Application.launch(args);
	}

	public void finalizarCompra() {

	}

	@Override
	public void handle(MouseEvent event) {
		
		if (event.getSource() == btnPesquisar) {

		}

		if (event.getSource() == btnAdicionar) {

		}
		
		if (event.getSource() == btnFinalizar) {

		}

	}

}
