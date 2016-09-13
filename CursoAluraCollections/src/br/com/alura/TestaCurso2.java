package br.com.alura;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestaCurso2 {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as cole��es Java", "Elton");

		javaColecoes.adiciona(new Aula("Trabalhando com arrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com cole��es", 22));

		List<Aula> aulasImutaveis = javaColecoes.getAulas();

		System.out.println(aulasImutaveis);

		List<Aula> aulasMutaveis = new ArrayList<>(aulasImutaveis);

		Collections.sort(aulasMutaveis);

		System.out.println(aulasMutaveis);

		System.out.println(javaColecoes.getTempoTotal());

		System.out.println(javaColecoes);
	}

}
