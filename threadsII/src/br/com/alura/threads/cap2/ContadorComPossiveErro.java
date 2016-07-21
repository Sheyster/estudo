/**
 * 
 */
package br.com.alura.threads.cap2;

/**
 * @author eltonf
 *
 */
public class ContadorComPossiveErro implements Runnable {

	private int darErro;
	private int numeroThread;

	public ContadorComPossiveErro(int darErro, int numeroThread) {
		this.darErro = darErro;
		this.numeroThread = numeroThread;
	}

	public ContadorComPossiveErro(int numeroThread) {
		this.numeroThread = numeroThread;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			if (i == darErro) {
				throw new RuntimeException("Erro na Thread " + numeroThread + " ao contar " + i);
			}
			System.out.println("Thread " + numeroThread + " conta " + i);
		}
	}

}
