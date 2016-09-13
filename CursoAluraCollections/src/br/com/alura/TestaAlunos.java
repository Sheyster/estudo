package br.com.alura;

import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {
		Set<String> alunos = new HashSet<>();
		alunos.add("Maria");
		alunos.add("João");
		alunos.add("Roberto");
		alunos.add("Ana");

		System.out.println(alunos);

		for (String aluno : alunos) {
			System.out.println(aluno);
		}
	}

}
