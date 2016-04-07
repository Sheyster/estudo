/**
 * 
 */
package br.com.alura.threads.cap3;

/**
 * @author eltonf
 *
 */
public class Principal implements Runnable {

	private volatile double total = 1;

	public static void main(String[] args) {
		new Thread(new Principal()).start();

		new Thread(new Principal()).start();

		new Thread(new Principal()).start();

		new Thread(new Principal()).start();

		new Thread(new Principal()).start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			total = total * 1.5;
			System.out.println(total);
		}
	}
}
