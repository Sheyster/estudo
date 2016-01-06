/**
 * 
 */
package br.com.alura.programa;

import java.util.TreeSet;

/**
 * @author eltonf
 *
 */
public class TestaTreeSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final TreeSet<Integer> numeros = new TreeSet<>();

		for (int i = 1; i < 1000; i++) {
			numeros.add(i);
		}

		for (final Integer integer : numeros.descendingSet()) {
			System.out.println(integer);
		}
	}

}
