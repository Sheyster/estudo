package br.com.alura.algoritmosII;

public class TestaPivota {

	public static void main(String[] args) {
		registros guilherme = new registros("Guilherme", 7);
		registros[] notas = { new registros("Andre", 4.0), new registros("Carlos", 8.5), new registros("Ana", 10), new registros("Jonas", 3.0),
				new registros("Juliana", 6.7), new registros("Lucia", 9.3), new registros("Paulo", 9.0), new registros("Mariana", 5.0),
				guilherme };

		int possicao = particiona(notas, 0, notas.length);

		for (registros nota : notas) {
			System.out.println("Aluno: " + nota.getAluno() + " nota " + nota.getValor());
		}

		System.out.println(possicao);
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
