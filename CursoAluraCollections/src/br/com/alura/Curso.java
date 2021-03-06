package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {

	private String nome;
	private String instrutor;
	private List<Aula> aulas = new ArrayList<>();

	public Curso(String nome, String instrutor) {
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public String getNome() {
		return nome;
	}

	public String getInstrutor() {
		return instrutor;
	}

	public List<Aula> getAulas() {
		// Utilizado para n�o deixa modificar a lista, podendo somente modificar
		// atraves do m�todo adiciona
		return Collections.unmodifiableList(aulas);
	}

	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}

	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + ", " + "aulas: " + this.aulas + "]";
	}

	public int getTempoTotal() {
		// int tempoTotal = 0;
		// for (Aula aula : aulas) {
		// tempoTotal += aula.getTempo();
		// }
		// return tempoTotal;
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
}
