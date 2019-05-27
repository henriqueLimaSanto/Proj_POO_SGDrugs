package com.curso.boundary;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import com.curso.control.ControlClientes;
import com.curso.entity.Cliente;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
	ControlClientes cc;
	// Paineis Realizar Vendas(RV) InfoCliente(IC), Grid
	private Pane PaneRV,PaneIC;
	private GridPane panegrid;
	// boxÂ´s verticais / horizontais
	private VBox btnAvancarInfo,RV,Infos;
	private GridPane IC;
	private HBox btnsRV;
	// realizar venda
	private TextField cpfCliente;
	private Button btnPesquisar,btnAvancar;
	private Label RealVendas,InfoAvancar;
	// info cliente
	private Label InfoCliente,nameClient,cpfClient,idadeClient,sexClient;
	private Label ruaClient,nClient,cidadeClient;
	private Button btnAvancarSDef;
	@Override
	public void start(Stage stgPreV) throws Exception {
		// Box REALIZAR VENDA
		cc					= new ControlClientes();
		RealVendas 			= new Label("REALIZAR VENDA");
		cpfCliente 			= new TextField();
		cpfCliente.setPromptText("Insira o CPF do Cliente");//Funciona como um placeholder
		btnPesquisar 		= new Button("PESQUISAR");
		btnAvancar 			= new Button("AVANÇAR");
		InfoAvancar 		= new Label("Necessario definir um cliente");
		// Box Info Cliente
		InfoCliente 		= new Label("INFO. CLIENTE");
		nameClient 			= new Label();
		cpfClient 			= new Label();
		idadeClient 		= new Label();
		sexClient 			= new Label();
		ruaClient 			= new Label();
		nClient 			= new Label();
		cidadeClient 		= new Label();
		btnAvancarSDef 		= new Button("AVANÇAR SEM DEFINIR CLIENTE");
		// Paineis Realizar Venda, InformaÃ§Ã£o Cliente e o grid
		panegrid 			= new GridPane();
		PaneRV 				= new Pane();
		PaneRV.setStyle("-fx-background-color: green;");

		PaneIC 				= new Pane();
		// Adicionando no grid os dois paineis
		//panegrid.add(PaneRV, 1,0);
		//panegrid.add(PaneIC, 2,0);
//													INICIO REALIZAR VENDAS

		btnAvancarInfo 		= new VBox(5, btnAvancar,InfoAvancar);
		btnAvancarInfo.setAlignment(Pos.TOP_CENTER);
		btnsRV 				= new HBox(btnPesquisar,btnAvancarInfo);
		VBox entradaPesq = new VBox(10, cpfCliente,btnsRV);
		entradaPesq.setAlignment(Pos.CENTER);
		RV 					= new VBox(RealVendas, entradaPesq);
		PaneRV.getChildren().add(RV);
		
//													FIM REALIZAR VENDAS
		
//													INICIO INFORMAÃ‡ÃƒO CLIENTE
		
		Infos 				= new VBox(new HBox(10,new Label("Nome: "),nameClient)
				        	 ,new HBox(10,new Label("CPF: "),cpfClient)
				  	         ,new HBox(10,new Label("Idade: "),idadeClient
				  				         ,new Label(" Sexo: "),sexClient)
				  	         ,new HBox(10,new Label("Endereço: "))
				  	         ,new HBox(10,ruaClient)
				  	         ,new HBox(10,new Label("N°"),nClient,new Label(", "),cidadeClient));
		//IC 					= new VBox(InfoCliente,Infos,btnAvancarSDef);
		IC 					= new GridPane();
		IC.add(InfoCliente, 0, 0);
		IC.add(Infos, 0, 1);
		IC.add(btnAvancarSDef, 0, 2);
		PaneIC.getChildren().add(IC);
		
		panegrid.add(RV, 0, 0);
		panegrid.add(IC, 1, 0);
		
//													FIM INFORMAÃ‡ÃƒO CLIENTE
		btnPesquisar.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
		btnAvancar.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
		btnAvancarSDef.addEventFilter(MouseEvent.MOUSE_CLICKED, this);
		Styles();
		Scene mainScene = new Scene(panegrid, 1360, 700);
		stgPreV.setScene(mainScene);
		stgPreV.setTitle("Seleção de Cliente - Pré Tela de Vendas");
		stgPreV.show();
		
		RV.setPrefHeight(panegrid.getHeight());
		RV.setPrefWidth(panegrid.getWidth() * 0.67);
		IC.setPrefHeight(panegrid.getHeight());
		IC.setPrefWidth(panegrid.getWidth() * 0.33);

		
		
	}
	
	public void Styles() {
		// styles
			//									STYLE REALIZAR VENDA
				PaneRV.setPrefWidth(600);
				btnsRV.setStyle("-fx-min-width: 800px; -fx-font-size: 15px;");
				btnsRV.setAlignment(Pos.BASELINE_CENTER);
				btnsRV.setSpacing(30);
				RV.setPadding(new Insets(10));
				RV.setStyle("-fx-font-family:'Arial'; -fx-background-color: #FFFFFF");
				RV.setAlignment(Pos.BASELINE_CENTER);
				RV.setSpacing(190);
				
				RealVendas.setStyle("-fx-font-size: 24px;");
				//RealVendas.setPadding(new Insets(20,0,0,0));
				cpfCliente.setStyle("-fx-max-width:800px;"+
								    "-fx-min-height:35px;"+
								    "-fx-font-size:15px;"
								    + "-fx-background-radius: 8;");
				btnPesquisar.setStyle("-fx-background-color:#00BFFF;"+
									  "-fx-background-radius:8px;"+
									  "-fx-min-width:386px;"+
									  "-fx-min-height:35px;"+
									  "-fx-font-size:15px;"+
									  "-fx-text-fill: white;"
									  + "-fx-cursor: hand;"+
									  "-fx-border-radius:8px;");
				btnAvancar.setStyle("-fx-background-color:#228B22;"+
									"-fx-background-radius:8px;"+
									"-fx-min-width:386px;"+
									"-fx-min-height:35px;"+
									"-fx-font-size:15px;"+
									"-fx-text-fill: white;"
									+ "-fx-cursor: hand;"+
									"-fx-border-radius:8px;");
				InfoAvancar.setStyle("-fx-font-size:12px;");
		   //				                    STYLE INFORMAÃ‡ÃƒO CLIENTE
				PaneIC.setPrefWidth(300);
				Infos.setPadding(new Insets(90,0,56,20));
				Infos.setSpacing(40);
				Infos.setMinHeight(590);
				Infos.setStyle("-fx-font-size: 20px; -fx-min-width: 450px;");
				IC.setStyle("-fx-background-color:#EEE5DE;"+
							"-fx-font-family:'Arial';"+
							"-fx-font-size:15;");
				IC.setAlignment(Pos.TOP_CENTER);
				IC.setPadding(new Insets(10, 0, 0, 0));
				InfoCliente.setStyle("-fx-font-size:24px; -fx-min-width: 450px;");
				InfoCliente.setAlignment(Pos.CENTER);
				//InfoCliente.setPadding(new Insets(20,0,0,60));
				btnAvancarSDef.setStyle("-fx-background-color:#228B22;"+
										"-fx-min-width: 450px;"+
										"-fx-min-height:74px;"+
									    "-fx-font-size: 15px;"+
										"-fx-text-fill: white;"
										+ "-fx-cursor: hand;"
										+ "-fx-border-radius: none;");
				
	}
	public static void main(String[]args) {
		Application.launch(args);
	}
	@SuppressWarnings("deprecation")
	public String Idade(Date dt_nasc) {//yyyy-MM-dd
        Calendar calHoje = GregorianCalendar.getInstance();
        int diah = calHoje.get(Calendar.DAY_OF_MONTH);
        int mesh = calHoje.get(Calendar.MONTH) + 1;
        int anoh = calHoje.get(Calendar.YEAR);
        // Data do nascimento.
        int dian = dt_nasc.getDay();
        int mesn = dt_nasc.getMonth();
        int anon = dt_nasc.getYear();
        
        String strNiver = anoh+"-"+mesn+"-"+dian;        
        Calendar calNiver = Calendar.getInstance();
        try {
            calNiver.setTime(new SimpleDateFormat("yyyy-MM-dd").parse(strNiver));
        } catch (ParseException e) {
        	e.printStackTrace();
        }
        
        int anos = (calHoje.getTimeInMillis() < calNiver.getTimeInMillis())? (anoh-anon-1):anoh-anon ;
        int meses;
        int dias;
        
        meses = mesh - mesn;
        if (meses > 0) {//Verificando se já fez aniversário ou não
            if (diah < dian) {
                meses--;
            }
        } else if (meses < 0) {//Se o mês atual for menor que o mês do aniversário
            meses = 12 + meses;//Lembrar que meses está negativo, por isso a soma;
            //Da mesma forma, vamos comparar o dia atual com o dia do aniversário, para sabermos se o mês está completo ou não:
            if (diah < dian) {
                meses--;
            }
        } else {//Se o mês atual for o mês do aniversário:
            if (diah<dian) {
                meses = 11;
            } 
        }
        
        dias = diah - dian;
        if (dias < 0) {//Se dia hoje menor que dia do niver, somar os dias desde o mês anterior:
            if (mesh==5||mesh==7||mesh==8||mesh==10||mesh==12) {
                dias = 30-dian+diah;
            } else if (mesh==1||mesh==2||mesh==4||mesh==6||mesh==9||mesh==11) {
                dias = 31-dian+diah;
            } else {//Verificando se o ano é bissexto ou não: Esse else é para o mês 3, cujo anterior é fevereiro:
                if (anoh%4 == 0) {
                    dias = 29-dian+diah;
                } else {
                    dias = 28-dian+diah;
                }
            }
        }
        return anos+" anos";
    }
	@Override
	public void handle(MouseEvent event) {
		
		if(event.getSource() == btnPesquisar) {
			JOptionPane.showMessageDialog(null,"Entrou");
			if(cpfCliente.getText() != null) {
				Cliente cli = cc.pesquisarCliente(Long.parseLong(cpfCliente.getText()));
				if(cli != null) {
					this.nameClient.setText(cli.getPrimeiroNome());
					this.cpfClient.setText(String.valueOf(cli.getCpf()));
					this.idadeClient.setText(Idade(cli.getDt_nasc()));
					this.sexClient.setText(String.valueOf(cli.getSexo()));
					this.ruaClient.setText(cli.getEnd().getRua());
					this.nClient.setText(String.valueOf(cli.getEnd().getNumero()));
					this.cidadeClient.setText(cli.getEnd().getCidade());
				}else {
					JOptionPane.showMessageDialog(null, "Cliente Não Existe.", "Cliente inexistente.", JOptionPane.INFORMATION_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "Para pesquisar é necessario digitar o CPF.", "Cpf nulo.", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(event.getSource()==btnAvancarSDef) {
			TelaVendas tv = new TelaVendas();
			try {
				tv.start(new Stage());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(event.getSource() == btnAvancar) {
			if(cpfCliente.getText().equals("") || cpfCliente.getText().equals(null)) {
				Alert msgAlert = new Alert(Alert.AlertType.ERROR);
				msgAlert.setHeaderText("CPF EMPTY OR NULL !");
				msgAlert.setTitle("CPF DO CLIENTE VAZIO OU NULO!");
				msgAlert.setContentText("Para avançar é necessario digitar o cpf.");
				msgAlert.show();
			}else {
				TelaVendas tv = new TelaVendas();
				try {
					tv.start(new Stage());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

}
