package br.com.alura;

public class TestaCurso {

	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando as coleções Java", "Elton");

		// List<Aula> aulas = javaColecoes.getAulas();
		//
		// System.out.println(aulas);
		//
		// aulas.add(new Aula("Trabalhando com arrayList", 21));
		//
		// System.out.println(aulas);
		//
		// System.out.println(javaColecoes.getAulas());
		//
		// System.out.println(aulas == javaColecoes.getAulas());

		// System.out.println(javaColecoes.getAulas());

		// javaColecoes.getAulas().add(new Aula("Trabalhando com arrayList",
		// 21));

		javaColecoes.adiciona(new Aula("Trabalhando com arrayList", 21));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 20));
		javaColecoes.adiciona(new Aula("Modelando com coleções", 22));

		System.out.println(javaColecoes.getAulas());
	}

}
