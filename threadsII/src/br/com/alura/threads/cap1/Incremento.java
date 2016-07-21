/**
 * 
 */
package br.com.alura.threads.cap1;

/**
 * @author eltonf
 *
 */
public class Incremento {

	private int valor;

	public Incremento(int inicial) {
		this.valor = inicial;
	}

	public int get() {
		return this.valor;
	}

	public void dobrar() {
		this.valor = this.valor * 2;
	}
}
