package com.curso.entity;

import javafx.scene.control.Button;

public class ProblemaSaude {
	
	private int id_problema;
	private String tipo;
	private String desc_problema;
	
	private Button btnExcluir;
	
	public ProblemaSaude() {
		this.btnExcluir = new Button("Excluir");
	}

	public ProblemaSaude(int id_problema, String tipo, String desc_problema) {
		this.id_problema = id_problema;
		this.tipo = tipo;
		this.desc_problema = desc_problema;
		this.btnExcluir = new Button("Excluir");
	}
	
	public Button getBtnExcluir() {
		return btnExcluir;
	}
	
	public int getId_problema() {
		return id_problema;
	}
	public void setId_problema(int id_problema) {
		this.id_problema = id_problema;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDesc_problema() {
		return desc_problema;
	}
	public void setDesc_problema(String desc_problema) {
		this.desc_problema = desc_problema;
	}
	
	
	
}
