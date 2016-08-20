package br.com.alura.algoritmosII;

public class registros {

	private String aluno;
	private double valor;

	public registros(String aluno, double valor) {
		this.aluno = aluno;
		this.valor = valor;
	}

	public String getAluno() {
		return this.aluno;
	}

	public double getValor() {
		return this.valor;
	}
}
