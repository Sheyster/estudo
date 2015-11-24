package br.com.alura;

import br.com.alura.face.Tributavel;

public class GerenciadorDeImpostoDeRenda {

	private double total;
	
	public void adiciona(Tributavel tributavel){
		System.out.println("Adicionando tributavel: " + tributavel);
		this.total += tributavel.calculaTributos();
	}
	
	public double getTotal() {
		return this.total;
	}
}
