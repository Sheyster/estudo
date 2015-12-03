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
	}

}
