/**
 * 
 */
package br.com.alura.programa;

/**
 * @author eltonf
 *
 */
public class TestaString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String s = "ab fj11 cd";
		final String s3 = "fj11";
		// final String s2 = s.replaceAll("1", "2");
		final String s4 = " teste teste ";
		final String s5 = "";
		System.out.println(s);

		if (s.contains(s3)) {
			System.out.println("A string " + s3 + " contém detro da string " + s);
		} else {
			System.out.println("A string " + s3 + " não contém detro da string " + s);
		}

		System.out.println(s4.replaceAll("\\s+$", ""));
		System.out.println(s4.replaceAll("^\\s+", ""));
		System.out.println(s5.isEmpty());
		System.out.println(s4.isEmpty());

		final String test = "12";
		final char[] num = new char[test.length()];
		int x = 0;

		for (int i = 0; i < test.length(); i++) {
			num[i] = test.charAt(i);
			x = Character.getNumericValue(num[i]);
			System.out.print(x);
		}

		System.out.println();
		final int result = converteParaInt(test);
		System.out.println(result);
	}

	// Método Alura
	private static int converteParaInt(String numero) {
		int resultado = 0;
		while (numero.length() > 0) {
			final char algarismo = numero.charAt(0);
			resultado = resultado * 10 + (algarismo - '0');
			numero = numero.substring(1);
		}
		return resultado;
	}
}
