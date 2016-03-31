/**
 * 
 */
package br.com.alura.threads.cap3;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static void main(String[] args) {
		Thread[] threads = new Thread[10];

		for (int i = 0; i < 10; i++) {
			Contatodor c = new Contatodor(Integer.toString(i + 1));
			threads[i] = new Thread(c);
		}

		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}

		System.out.println("Fim do programa principal");
	}
}
