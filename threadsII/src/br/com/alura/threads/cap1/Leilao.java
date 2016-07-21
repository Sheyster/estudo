/**
 * 
 */
package br.com.alura.threads.cap1;

/**
 * @author eltonf
 *
 */
public class Leilao {

	private int valorCorrente;

	public Leilao(int lanceInicial) {
		this.valorCorrente = lanceInicial;
	}

	public int getCorrente() {
		return this.valorCorrente;
	}

	public void darLance(int valor) {
		this.valorCorrente = this.valorCorrente + valor;
	}
}
