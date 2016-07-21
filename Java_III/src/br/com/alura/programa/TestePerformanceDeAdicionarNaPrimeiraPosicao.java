/**
 * 
 */
package br.com.alura.programa;

import java.util.LinkedList;
import java.util.List;

/**
 * @author eltonf
 *
 */
public class TestePerformanceDeAdicionarNaPrimeiraPosicao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		final long inicio = System.currentTimeMillis();

		final List<Integer> teste = new LinkedList<>();

		for (int i = 0; i < 90000; i++) {
			teste.add(0, 1);
		}

		final long fim = System.currentTimeMillis();
		final double tempo = (fim - inicio) / 1000.0;

		System.out.println("Tempo gasto: " + tempo);
	}

}
