/**
 * 
 */
package br.com.alura.threads.cap5;

/**
 * @author eltonf
 *
 */
public class NotaFiscal {

	private int total;

	public NotaFiscal(int total) {
		super();
		this.total = total;
	}

	/**
	 * @return the total
	 */
	public synchronized int getTotal() {
		return total;
	}
}
