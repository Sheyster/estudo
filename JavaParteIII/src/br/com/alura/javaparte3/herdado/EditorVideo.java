package br.com.alura.javaparte3.herdado;

//Gerente eh um Funcionario, Gerente herda da class Funcionario
public class EditorVideo extends Funcionario {

	public double getBonificacao() {
		System.out.println("Chamando o método de bonificacao do Editor de video");
		return 150;
	}

}