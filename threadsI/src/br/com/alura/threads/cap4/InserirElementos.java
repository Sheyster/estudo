/**
 * 
 */
package br.com.alura.threads.cap4;

/**
 * @author eltonf
 *
 */
public class InserirElementos implements Runnable {

	private int numeroThread;

	/**
	 * 
	 */
	public InserirElementos(int numeroThread) {
		this.numeroThread = numeroThread;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			/* synchronized (Armazenamento.instancia) { */
			Armazenamento.instancia.adicionaElemento("Thread " + numeroThread + " - " + i);
			/* } */
		}
	}

}
