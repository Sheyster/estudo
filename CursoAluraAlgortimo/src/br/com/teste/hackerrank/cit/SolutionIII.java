package br.com.teste.hackerrank.cit;

import br.com.alura.algoritmosII.registros;

public class SolutionIII {

	public static void main(String[] args) {
		// int registros[] = { 1, 2, 3, 4, 5 };

		int registros[] = { 6, 10, 5, 7, 9, 2, 2 };

		ordena(registros, 0, registros.length);

		for (int i = 0; i < registros.length; i++) {
			System.out.print(registros[i] + " ");
		}

		System.out.println();

		int registroIntercalado[] = intercala(registros, 0, registros.length);

		for (int i = 0; i < registroIntercalado.length; i++) {
			System.out.print(registroIntercalado[i] + " ");
		}
	}

	private static int[] intercala(int[] registros, int de, int ate) {
		int retorno[] = new int[registros.length];
		int meio = (de + ate) / 2;
		int resto = (de + ate) % 2;
		int tamanho = registros.length;
		int aux = 0;

		for (int i = 0; i < meio; i++) {
			retorno[aux++] = registros[i];
			retorno[aux++] = registros[tamanho - 1];
			tamanho--;
		}

		if (resto != 0) {
			retorno[aux] = registros[meio];
		}

		return retorno;
	}

	private static int busca(registros[] registros, int de, int ate, double buscando) {
		if (de > ate) {
			return -1;
		}

		int meio = (de + ate) / 2;
		registros nota = registros[meio];
		if (buscando == nota.getValor()) {
			return meio;
		}
		if (buscando < nota.getValor()) {
			return busca(registros, de, meio - 1, buscando);
		}

		return busca(registros, meio + 1, ate, buscando);
	}

	private static void ordena(int[] registros, int de, int ate) {
		int elementos = ate - de;

		if (elementos > 1) {
			int posicaoDoPivo = particiona(registros, de, ate);
			ordena(registros, de, posicaoDoPivo);
			ordena(registros, posicaoDoPivo + 1, ate);
		}
	}

	private static int particiona(int[] registros, int i, int termino) {
		int pivo = registros[termino - 1];
		int menoresEncontrados = 0;

		for (int analisando = 0; analisando < termino - 1; analisando++) {
			int atual = registros[analisando];
			if (atual <= pivo) {
				troca(registros, analisando, menoresEncontrados);
				menoresEncontrados++;
			}
		}
		troca(registros, termino - 1, menoresEncontrados);

		return menoresEncontrados;
	}

	private static void troca(int[] registros, int de, int para) {
		int registros1 = registros[de];
		int registros2 = registros[para];

		registros[para] = registros1;
		registros[de] = registros2;
	}
}
