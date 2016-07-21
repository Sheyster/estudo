/**
 * 
 */
package br.com.alura.designpatterns.cap7;

import java.util.Calendar;

/**
 * @author eltonf
 *
 */
public class Pedido {

	private String cliente;
	private double valor;
	private Status status;
	private Calendar dataFinanlizacao;

	/**
	 * @param cliente
	 * @param valor
	 */
	public Pedido(String cliente, double valor) {
		this.cliente = cliente;
		this.valor = valor;
	}

	public void paga() {
		status = Status.PAGO;
	}

	public void finaliza() {
		dataFinanlizacao = Calendar.getInstance();
		status = Status.ENTREGUE;
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}
}
