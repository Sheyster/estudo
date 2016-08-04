package br.com.alura.algoritmosII;

public class TestaOrdenacaoRapida {

	public static void main(String[] args) {
		Nota guilherme = new Nota("Guilherme", 7);
		Nota[] notas = { new Nota("Andre", 4.0), new Nota("Carlos", 8.5), new Nota("Ana", 10), new Nota("Jonas", 3.0),
				new Nota("Juliana", 6.7), new Nota("Lucia", 9.3), new Nota("Paulo", 9.0), new Nota("Mariana", 5.0),
				guilherme };

		ordena(notas, 0, notas.length);

		for (Nota nota : notas) {
			System.out.println("Aluno: " + nota.getAluno() + " nota " + nota.getValor());
		}

	}

	private static void ordena(Nota[] notas, int de, int ate) {
		int elementos = ate - de;

		if (elementos > 1) {
			int posicaoDoPivo = particiona(notas, de, ate);
			ordena(notas, de, posicaoDoPivo);
			ordena(notas, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(Nota[] notas, int i, int termino) {
		Nota pivo = notas[termino - 1];
		int menoresEncontrados = 0;

		for (int analisando = 0; analisando < termino - 1; analisando++) {
			Nota atual = notas[analisando];
			if (atual.getValor() <= pivo.getValor()) {
				troca(notas, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		troca(notas, termino - 1, menoresEncontrados);

		return menoresEncontrados;
	}

	private static void troca(Nota[] notas, int de, int para) {
		Nota nota1 = notas[de];
		Nota nota2 = notas[para];

		notas[para] = nota1;
		notas[de] = nota2;

	}

}
