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
		final String s2 = s.replaceAll("1", "2");
		System.out.println(s);

		if (s.contains(s3)) {
			System.out.println("A string " + s3 + " contém detro da string "
					+ s);
		} else {
			System.out.println("A string " + s3
					+ " não contém detro da string " + s);
		}

		String test = "12";
		char[] num = new char[test.length()];
		int x = 0;

		for (int i = 0; i < test.length(); i++) {
			num[i] = test.charAt(i);
			x = Character.getNumericValue(num[i]);
			System.out.print(x);
		}

		System.out.println();
		int result = converteParaInt(test);
		System.out.println(result);
	}

	// Método Alura
	private static int converteParaInt(String numero) {
		int resultado = 0;
		while (numero.length() > 0) {
			char algarismo = numero.charAt(0);
			resultado = resultado * 10 + (algarismo - '0');
			numero = numero.substring(1);
		}
		return resultado;
	}
}
