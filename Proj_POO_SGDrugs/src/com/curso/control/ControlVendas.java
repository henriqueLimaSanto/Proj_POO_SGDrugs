package com.curso.control;

import java.util.List;

import com.curso.entity.Cliente;
import com.curso.entity.FarmaciaProduto;
import com.curso.entity.Venda;

public class ControlVendas {

	private Venda vendaAtual;
	private List<FarmaciaProduto> produtos;
	private List<Cliente> clientes;

	public Venda getVendaAtual() {
		return vendaAtual;
	}
	public void setVendaAtual(Venda vendaAtual) {
		this.vendaAtual = vendaAtual;
	}
	public List<FarmaciaProduto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<FarmaciaProduto> produtos) {
		this.produtos = produtos;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
}
