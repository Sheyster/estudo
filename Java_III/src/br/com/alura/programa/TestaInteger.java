/**
 * 
 */
package br.com.alura.programa;

import java.io.PrintStream;

/**
 * @author eltonf
 *
 */
public class TestaInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Integer x1 = new Integer(10);
		final Integer x2 = new Integer(10);
		final String s = "123";
		final String s1 = "abc";

		if (x1 == x2) {
			System.out.println("igual");
		} else {
			System.out.println("diferente");
		}

		if (x1.equals(x2)) {
			System.out.println("igual");
		} else {
			System.out.println("diferente");
		}

		System.out.println(Integer.parseInt(s));
		// System.out.println(Integer.parseInt(s1));

		final PrintStream saida = System.out;
		saida.println("ola");
	}

}
