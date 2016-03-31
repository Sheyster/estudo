/**
 * 
 */
package br.com.alura.threads.cap3;

/**
 * @author eltonf
 *
 */
public class Contatodor implements Runnable {

	private String nome;

	public Contatodor(String nome) {
		this.nome = nome;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 100; i++) {
			System.out.println("Thread " + nome + " - contando " + i);
		}
	}

}
