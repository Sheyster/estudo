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
			System.out.println("A string " + s3 + " cont�m detro da string " + s);
		} else {
			System.out.println("A string " + s3 + " n�o cont�m detro da string " + s);
		}
	}

}
