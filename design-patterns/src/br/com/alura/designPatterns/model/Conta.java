/**
 * 
 */
package br.com.alura.designPatterns.model;

/**
 * @author eltonf
 *
 */
public class Conta {

	private double saldo;

	public void deposita(double valor) {
		this.saldo += valor;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
}
