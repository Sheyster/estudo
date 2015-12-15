/**
 * 
 */
package br.com.alura.programa;

import java.util.Collection;
import java.util.HashSet;

/**
 * @author eltonf
 *
 */
public class TestaPerformance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Iniciando...");
		final Collection<Integer> teste = new HashSet<>();
		final long inicio = System.currentTimeMillis();

		final int total = 30000;

		for (int i = 0; i < total; i++) {
			teste.add(i);
		}

		for (int i = 0; i < total; i++) {
			teste.contains(i);
		}

		final long fim = System.currentTimeMillis();
		final long tempo = fim - inicio;
		System.out.println("Tempo gasto: " + tempo);
	}

}
