/**
 * 
 */
package br.com.alura.teste;

/**
 * @author eltonf
 *
 */
public class TesteErro {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Inicio do main");
		try {
			metodo1();
		} catch (final ArrayIndexOutOfBoundsException e) {
			System.out.println("Posição inválida!");
		}
		System.out.println("Final do main");
	}

	private static void metodo1() {
		System.out.println("Inicio do metodo 1");
		metodo2();

		System.out.println("Final do metodo 1");
	}

	private static void metodo2() {
		System.out.println("Inicio do metodo 2");
		final int[] array = new int[10];
		for (int i = 0; i <= 15; i++) {
			array[i] = i;
			System.out.println(i);

		}
		System.out.println("Final do metodo 2");
	}

}
