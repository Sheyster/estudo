package br.com.manipulacaostring;

public class TesteDoceS2 {

	public static void main(String[] args) {
		int[] ratings = { 7, 6, 7, 7, 8, 6, 9, 9 };
		candy(ratings);
	}

	private static int candy(int[] ratings) {
		int aux = 0;
		int contador = 0;
		int nota = 0;
		for (int i = 0; i < ratings.length; i++) {
			System.out.print(ratings[i] + ", ");
		}
		int[] order = ordenar(ratings);
		System.out.println("");
		for (int i = 0; i < order.length; i++) {
			System.out.print(order[i] + ", ");
		}

		for (int i = 0; i < order.length; i++) {
			if (nota == 0) {
				nota = order[i];
				contador++;
				aux = contador;
			} else if (nota == order[i]) {
				aux += contador;
			} else {
				nota = order[i];
				contador++;
				aux += contador;
			}
		}

		System.out.println("");

		System.out.print(aux);

		return aux;
	}

	private static int[] ordenar(int[] ratings) {
		int aux = 0;
		for (int i = 0; i < ratings.length; i++) {
			for (int j = 0; j < ratings.length; j++) {
				if (ratings[i] <= ratings[j]) {
					aux = ratings[i];
					ratings[i] = ratings[j];
					ratings[j] = aux;
				}
			}
		}
		return ratings;
	}
}
