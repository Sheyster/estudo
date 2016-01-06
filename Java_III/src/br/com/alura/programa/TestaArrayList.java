/**
 * 
 */
package br.com.alura.programa;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author eltonf
 *
 */
public class TestaArrayList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final ArrayList<Integer> numeros = new ArrayList<>();

		for (int i = 1; i < 1000; i++) {
			numeros.add(i);
		}

		Collections.reverse(numeros);

		for (final Integer integer : numeros) {
			System.out.println(integer);
		}
	}

}
