package br.com.alura.algoritmosII;

public class TestaOrdenacaoAoIntercalar {

	public static void main(String[] args) {
		registros[] notas = { new registros("Andre", 4.0), new registros("Carlos", 8.5), new registros("Ana", 10), new registros("Jonas", 3.0),
				new registros("Juliana", 6.7), new registros("Guilherme", 7), new registros("Paulo", 9.0), new registros("Mariana", 5.0),
				new registros("Lucia", 9.3) };

		ordena(notas, 0, notas.length);

		for (registros nota : notas) {
			System.out.println("Aluno: " + nota.getAluno() + ", nota: " + nota.getValor());
		}
	}

	private static void ordena(registros[] notas, int inicial, int termino) {
		int quantidade = termino - inicial;

		if (quantidade > 1) {
			int meio = (inicial + termino) / 2;

			ordena(notas, inicial, meio);
			ordena(notas, meio, termino);

			intercalar(notas, inicial, meio, termino);
		}

		/*
		 * intercalar(notas, inicial, 8, termino);
		 * 
		 * intercalar(notas, 0, 1, 2); intercalar(notas, 2, 3, 4);
		 * intercalar(notas, 0, 2, 4);
		 * 
		 * intercalar(notas, 4, 5, 6); intercalar(notas, 6, 7, 8);
		 * intercalar(notas, 4, 6, 8);
		 * 
		 * intercalar(notas, 0, 4, 8);
		 * 
		 * intercalar(notas, 0, 8, 9);
		 */
	}

	private static void intercalar(registros[] notas, int inicial, int miolo, int termino) {
		registros[] resultado = new registros[termino - inicial];

		int atual = 0;
		int atual1 = inicial;
		int atual2 = miolo;

		while (atual1 < miolo && atual2 < termino) {
			registros nota1 = notas[atual1];
			registros nota2 = notas[atual2];
			if (nota1.getValor() < nota2.getValor()) {
				resultado[atual] = nota1;
				atual1++;
			} else {
				resultado[atual] = nota2;
				atual2++;
			}
			atual++;
		}

		while (atual2 < termino) {
			resultado[atual++] = notas[atual2++];
			// atual++;
			// atualAlberto++;
		}

		while (atual1 < miolo) {
			resultado[atual] = notas[atual1];
			atual++;
			atual1++;
		}

		for (int contador = 0; contador < atual; contador++) {
			notas[inicial + contador] = resultado[contador];
		}

	}

}
