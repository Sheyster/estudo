/**
 * 
 */
package br.com.test.collection;

import static br.com.test.collection.VectoresConst.vector1;
import static br.com.test.collection.VectoresConst.vector2;
import static br.com.test.collection.VectoresConst.vector3;

/**
 * @author TON
 *
 */
public class WithOutCollection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer vectores[] = new Integer[vector1.length + vector2.length + vector3.length];

		// Inicializando o vetor com o valor de todos os vetores
		for (int i = 0; i < vector1.length; i++) {
			vectores[i] = vector1[i];
			vectores[i + vector1.length] = vector2[i];
			vectores[i + vector1.length + vector2.length] = vector3[i];
		}

		// Mostrar todos os valores inserido
		for (Integer integer : vectores) {
			System.out.print(integer + " ");
		}

		ordernar(vectores);

		Integer vectorOrdenado[] = vectores;

		Integer vtRepitido[] = repetidos(vectorOrdenado);

		Integer vtSemRepetido[] = removerDuplicado(vectores);

		naoDuplicados(vtRepitido, vtSemRepetido);

	}

	private static void naoDuplicados(Integer[] vtRepitido, Integer[] vtSemRepetido) {
		Integer naoDuplicados[] = new Integer[vtSemRepetido.length];

		for (int i = 0; i < vtSemRepetido.length; i++) {
			boolean temIgual = false;
			if (vtSemRepetido[i] != null) {
				for (int j = 0; j < vtRepitido.length; j++) {
					if (vtRepitido[j] != null) {
						if (vtSemRepetido[i] == vtRepitido[j]) {
							temIgual = true;
							break;
						}
					}
				}
				if (!temIgual) {
					naoDuplicados[i] = vtSemRepetido[i];
				}
			}
		}

		System.out.println("");
		// Mostrar todos os valores repetidos
		for (Integer integer : naoDuplicados) {
			if (integer != null) {
				System.out.print(integer + " ");
			}
		}
	}

	private static Integer[] removerDuplicado(Integer[] vectores) {
		Integer naoRepitidos[] = new Integer[vectores.length];
		Integer indice = 0;
		for (int i = 0; i < vectores.length; i++) {
			boolean exite = false;
			for (int j = 0; j < indice; j++) {
				if (vectores[i] == naoRepitidos[j]) {
					exite = true;
					break;
				}
			}
			if (!exite) {
				naoRepitidos[indice] = vectores[i];
				indice++;
			}
		}

		System.out.println("");
		// Mostrar todos os valores repetidos
		for (Integer integer : naoRepitidos) {
			if (integer != null) {
				System.out.print(integer + " ");
			}
		}

		return naoRepitidos;
	}

	private static Integer[] repetidos(Integer[] vectores) {
		Integer repetidos[] = new Integer[vectores.length];

		for (int i = 0; i < vectores.length; i++) {
			Integer contador = 0;
			for (int j = i + 1; j < repetidos.length; j++) {
				if (vectores[i] == vectores[j]) {
					contador++;
				}
			}
			if (contador == 1) {
				repetidos[i] = vectores[i];
			}
		}
		System.out.println("");
		// Mostrar todos os valores repetidos
		for (Integer integer : repetidos) {
			if (integer != null) {
				System.out.print(integer + " ");
			}
		}

		return repetidos;
	}

	private static void ordernar(Integer[] vectores) {
		Integer aux = 0;
		for (int i = 0; i < vectores.length; i++) {
			for (int j = 0; j < vectores.length; j++) {
				if (vectores[i] <= vectores[j]) {
					aux = vectores[i];
					vectores[i] = vectores[j];
					vectores[j] = aux;
				}
			}
		}

		System.out.println("");

		// Mostrar todos os valores inserido ordenados
		for (Integer integer : vectores) {
			System.out.print(integer + " ");
		}
	}

}
