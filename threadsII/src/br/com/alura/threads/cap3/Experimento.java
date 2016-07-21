/**
 * 
 */
package br.com.alura.threads.cap3;

/**
 * @author eltonf
 *
 */
public class Experimento {

	public static void main(String[] args) {
		Experimento experimento = new Experimento();
		experimento.executar();
	}

	private volatile int a = 0;
	private volatile int b = 0;
	private boolean parar = false;

	public void executar() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!parar) {
					incrementar();
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!parar) {
					verifica();
				}
			}
		}).start();
	}

	public void incrementar() {
		a += 1;
		b += 1;
		if (a == Integer.MAX_VALUE) {
			a = 0;
			b = 0;
		}
	}

	public void verifica() {
		if (b > a) {
			System.out.println("Alguma coisa está errada! a = " + a + " b = " + b);
		} else {
			System.out.println("Tudo sob controle! a = " + a + " b = " + b);
		}
	}
}
