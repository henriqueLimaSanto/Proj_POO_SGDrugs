package com.curso.control;

import java.util.List;

import javax.swing.JOptionPane;

import com.curso.entity.Cliente;
import com.curso.entity.Endereco;
import com.curso.entity.ProblemaSaude;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ControlClientes {
	
	private List<Cliente> clientesCadastrados;
	private List<Endereco> enderecoCadastrados;
	private List<ProblemaSaude> problemasCadastrados;
	private ObservableList<Cliente> dataList = FXCollections.observableArrayList();
	private ObservableList<ProblemaSaude> dataListPS = FXCollections.observableArrayList();
	
	public ObservableList<Cliente> getDataListClientes(){
		return this.dataList;
	}
	
	public ObservableList<ProblemaSaude> getDataListPS(){
		return this.dataListPS;
	}
	
	public void cadCliente(Cliente cl) {
		if(!existCliente(cl.getCpf())) {
			this.clientesCadastrados.add(cl);
		}else {
			JOptionPane.showMessageDialog(null, "Cliente já esta cadastrado no sistema !!!");
		}
	}
	
	private boolean existCliente(long cpf) {
		for(Cliente c : clientesCadastrados) {
			if(c.getCpf() == cpf) {
				return true;
			}
		}
		return false;
	}
	
	public void pesquisarCliente(String nome, long cpf, String uf, String cidade) {
		dataList.clear();
		if(!nome.equals("")) {
			for(Cliente c : clientesCadastrados) {
				if(c.getCpf() == cpf) {
					dataList.add(c);
				}
			}
		}
	}
	
	public void addProblema(ProblemaSaude ps) {
		this.problemasCadastrados.add(ps);
	}
	
	public void addEndereco(Endereco ed) {
		this.enderecoCadastrados.add(ed);
	}
	
	public void procurarProblema(ProblemaSaude ps) {
		boolean addPrb = true;
		for(ProblemaSaude p : problemasCadastrados) {
			if(p.getDesc_problema() == ps.getDesc_problema()) {
				addPrb = false;
				break;
			}
		}
		if(addPrb) {
			addProblema(ps);
		}
		dataListPS.add(ps);
	}
	
	public Endereco procurarEndereco(Endereco ed) {
		boolean addEd = true;
		for(Endereco e : enderecoCadastrados) {
			if(e.getCep() == ed.getCep()) {
				addEd = false;
				break;
			}
		}
		if(addEd) {
			addEndereco(ed);
		}
		return ed;
	}
	
}
