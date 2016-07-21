/**
 * 
 */
package br.com.alura.threads.cap4;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[100];

		for (int i = 1; i <= 10; i++) {
			threads[i - 1] = new Thread(new InserirElementos(i));
		}

		for (int i = 0; i < 10; i++) {
			threads[i].start();
		}

		Thread.sleep(2000);

		synchronized (Armazenamento.instancia) {
			String[] lista = Armazenamento.instancia.recuperaLista();
			if (Armazenamento.instancia.getContador() < 1000) {
				Armazenamento.instancia.wait();
			}
			for (String elemento : lista) {
				System.out.println(elemento);
			}
		}
	}
}
