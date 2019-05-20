package com.curso.entity;

import java.util.Date;
import java.util.List;

public class Cliente {
	
	private String primeiroNome;
	private Date dt_nasc;
	private int rg, cpf, telefone;
	private String email;
	private int cartaoSUS;
	private Endereco end;
	private List<ProblemaSaude> problemasSaude;
	public String getPrimeiroNome() {
		return primeiroNome;
	}
	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}
	public Date getDt_nasc() {
		return dt_nasc;
	}
	public void setDt_nasc(Date dt_nasc) {
		this.dt_nasc = dt_nasc;
	}
	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getCartaoSUS() {
		return cartaoSUS;
	}
	public void setCartaoSUS(int cartaoSUS) {
		this.cartaoSUS = cartaoSUS;
	}
	public Endereco getEnd() {
		return end;
	}
	public void setEnd(Endereco end) {
		this.end = end;
	}
	public List<ProblemaSaude> getProblemasSaude() {
		return problemasSaude;
	}
	public void setProblemasSaude(List<ProblemaSaude> problemasSaude) {
		this.problemasSaude = problemasSaude;
	}
	
	
	
}
