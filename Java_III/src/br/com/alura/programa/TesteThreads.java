/**
 * 
 */
package br.com.alura.programa;

import br.com.alura.threads.Programa;

/**
 * @author eltonf
 *
 */
public class TesteThreads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final Programa p1 = new Programa();
		p1.setId(1);

		final Thread t1 = new Thread(p1);
		t1.start();

		final Programa p2 = new Programa();
		p2.setId(2);

		final Thread t2 = new Thread(p2);
		t2.start();
	}

}
