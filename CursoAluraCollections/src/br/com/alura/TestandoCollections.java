package br.com.alura;

import java.util.ArrayList;

public class TestandoCollections {

	public static void main(String[] args) {
		String curso1 = "Java";
		String curso2 = "Angular";
		String curso3 = "Android";

		ArrayList<String> cursos = new ArrayList<>();
		cursos.add(curso1);
		cursos.add(curso2);
		cursos.add(curso3);

		System.out.println(cursos);

		cursos.remove(0);

		// Lambda Java 8
		cursos.forEach(aula -> {
			System.out.println("Aula: " + aula);
		});
	}

}
