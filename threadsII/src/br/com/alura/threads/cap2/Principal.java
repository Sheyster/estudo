/**
 * 
 */
package br.com.alura.threads.cap2;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static void main(String[] args) {
		// try {

		Thread.UncaughtExceptionHandler handler = new UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Erro capturado: " + e.getMessage());
			}
		};

		Thread t1 = new Thread(new ContadorComPossiveErro(1));
		t1.setUncaughtExceptionHandler(handler);
		Thread t2 = new Thread(new ContadorComPossiveErro(2));
		t2.setUncaughtExceptionHandler(handler);
		Thread t3 = new Thread(new ContadorComPossiveErro(3, 4));
		t3.setUncaughtExceptionHandler(handler);
		Thread t4 = new Thread(new ContadorComPossiveErro(4));
		t4.setUncaughtExceptionHandler(handler);
		Thread t5 = new Thread(new ContadorComPossiveErro(5, 8));
		t5.setUncaughtExceptionHandler(handler);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		// } catch (Exception e) {
		// System.out.println("Peguei a exceção da thread " + e);
		// }
	}
}
