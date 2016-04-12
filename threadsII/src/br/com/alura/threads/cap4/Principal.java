/**
 * 
 */
package br.com.alura.threads.cap4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static void main(String[] args) {
		ExecutorService ex = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			Contatodor c = new Contatodor();
			ex.execute(c);
		}

		System.out.println("Fim do programa principal");
		ex.shutdown();
	}
}
