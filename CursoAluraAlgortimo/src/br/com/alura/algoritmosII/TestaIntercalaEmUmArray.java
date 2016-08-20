package br.com.alura.algoritmosII;

public class TestaIntercalaEmUmArray {

	public static void main(String[] args) {
		registros[] notas = { new registros("Andre", 4), new registros("Mariana", 5), new registros("Carlos", 8.5), new registros("Paulo", 9),
				new registros("Jonas", 3), new registros("Juliana", 6.7), new registros("Guilherme", 7), new registros("Lucia", 9.3),
				new registros("Ana", 10) };

		registros[] rank = intercalar(notas, 0, 4, notas.length);
		for (registros nota : rank) {
			System.out.println("Aluno: " + nota.getAluno() + ", nota: " + nota.getValor());
		}
	}

	private static registros[] intercalar(registros[] notas, int inicial, int miolo, int termino) {
		registros[] resultado = new registros[termino];

		int atual1 = inicial;
		int atual2 = miolo;
		int atual = 0;

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
			resultado[atual++] = notas[atual1++];
			atual++;
			atual1++;
		}

		return resultado;
	}

}
