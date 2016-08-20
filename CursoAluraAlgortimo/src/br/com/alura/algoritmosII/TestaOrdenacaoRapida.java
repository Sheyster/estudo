package br.com.alura.algoritmosII;

public class TestaOrdenacaoRapida {

	public static void main(String[] args) {
		registros guilherme = new registros("Guilherme", 7);
		registros[] notas = { new registros("Andre", 4.0), new registros("Carlos", 8.5), new registros("Ana", 10), new registros("Jonas", 3.0),
				new registros("Juliana", 6.7), new registros("Lucia", 9.3), new registros("Paulo", 9.0), new registros("Mariana", 5.0),
				guilherme };

		ordena(notas, 0, notas.length);
		int encontrei = busca(notas, 0, notas.length, 9.3);

		if (encontrei >= 0) {
			System.out.println("Encontrei a nota em " + encontrei + ".");
		} else {
			System.out.println("Não encontrei a nota.");
		}

		for (registros nota : notas) {
			System.out.println("Aluno: " + nota.getAluno() + " nota " + nota.getValor());
		}

	}

	private static int busca(registros[] notas, int de, int ate, double buscando) {
		if (de > ate) {
			return -1;
		}

		int meio = (de + ate) / 2;
		registros nota = notas[meio];
		if (buscando == nota.getValor()) {
			return meio;
		}
		if (buscando < nota.getValor()) {
			return busca(notas, de, meio - 1, buscando);
		}

		return busca(notas, meio + 1, ate, buscando);

		// for (int atual = de; atual < ate; atual++) {
		// if (notas[atual].getValor() == buscando) {
		// return atual;
		// }
		// }
		// return -1;
	}

	private static void ordena(registros[] notas, int de, int ate) {
		int elementos = ate - de;

		if (elementos > 1) {
			int posicaoDoPivo = particiona(notas, de, ate);
			ordena(notas, de, posicaoDoPivo);
			ordena(notas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(registros[] notas, int i, int termino) {
		registros pivo = notas[termino - 1];
		int menoresEncontrados = 0;

		for (int analisando = 0; analisando < termino - 1; analisando++) {
			registros atual = notas[analisando];
			if (atual.getValor() <= pivo.getValor()) {
				troca(notas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		troca(notas, termino - 1, menoresEncontrados);

		return menoresEncontrados;
	}

	private static void troca(registros[] notas, int de, int para) {
		registros nota1 = notas[de];
		registros nota2 = notas[para];

		notas[para] = nota1;
		notas[de] = nota2;

	}

}
