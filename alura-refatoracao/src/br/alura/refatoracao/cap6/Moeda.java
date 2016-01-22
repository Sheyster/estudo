/**
 * 
 */
package br.alura.refatoracao.cap6;

/**
 * @author eltonf
 *
 */
public enum Moeda {

	DOLAR(2.7), EURO(3.0);

	private double taxa;

	/**
	 * 
	 */
	Moeda(double taxa) {
		this.taxa = taxa;
	}

	/**
	 * @return the taxa
	 */
	public double getTaxa() {
		return taxa;
	}
}
