package com.curso.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.curso.entity.Produto;

public class ControlProdutos {

	private List<Produto> ltProdutos = new ArrayList<>();
	private String arquivo = "regProdutos.txt";

	public void inserirProduto(Produto produto) throws IOException {

		BufferedWriter write = new BufferedWriter(new FileWriter(arquivo));

		for (Produto p : ltProdutos) {
			
			write.write(p.getNome());
			write.newLine();
			write.write(p.getCategoria());
			write.newLine();
		}

		write.close();

	}

	public void adicionarProduto(Produto p) {

			ltProdutos.add(p);
	}

}
