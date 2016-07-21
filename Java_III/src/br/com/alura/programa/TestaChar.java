/**
 * 
 */
package br.com.alura.programa;

/**
 * @author eltonf
 *
 */
public class TestaChar {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String s = "Socorram-me, subi no ônibus em Marrocos";

		// for (int i = 0; i < s.length(); i++) {
		// System.out.println(s.charAt(i));
		// }

		String invertido = "";
		for (int i = s.length(); i > 0; i--) {
			invertido += s.charAt(i - 1);
		}

		System.out.println(invertido);

		final String[] array = s.split(" ");
		String novo = "";

		for (int i = array.length - 1; i >= 0; i--) {
			novo += array[i] + " ";
		}

		System.out.println(novo);

		final String string = "Socorram-me, subi no ônibus em Marrocos";
		final String reverse = new StringBuffer(string).reverse().toString();
		System.out.println(reverse);

		final String result = new StringBuilder(string).reverse().toString();
		System.out.println(result);
	}

}
