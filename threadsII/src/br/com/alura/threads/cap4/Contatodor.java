/**
 * 
 */
package br.com.alura.threads.cap4;

/**
 * @author eltonf
 *
 */
public class Contatodor implements Runnable {

	@Override
	public void run() {
		long id = Thread.currentThread().getId();
		for (int i = 1; i <= 100; i++) {
			System.out.println("Thread " + id + " - contando " + i);
		}
	}

}
