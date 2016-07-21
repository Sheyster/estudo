/**
 * 
 */
package br.alura.refatoracao.cap4;

/**
 * @author eltonf
 *
 */
public class ContaBancaria {

	protected String titular;
	protected double saldo;

	/**
	 * @param titular
	 * @param saldo
	 */
	protected ContaBancaria(String titular, double saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public void saca(double valor) {
		this.saldo -= this.saldo - valor;
	}

	public void deposita(double valor) {
		this.saldo += this.saldo - valor;
	}

	/**
	 * @return the titular
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * @return the saldo
	 */
	public double getSaldo() {
		return saldo;
	}
}
