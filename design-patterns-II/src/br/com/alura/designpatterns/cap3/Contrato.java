/**
 * 
 */
package br.com.alura.designpatterns.cap3;

import java.util.Calendar;

/**
 * @author eltonf
 *
 */
public class Contrato {

	private Calendar data;
	private String nomeCliente;
	private TipoContrato tipoContrato;

	/**
	 * @param data
	 * @param nomeCliente
	 * @param tipoContrato
	 */
	public Contrato(Calendar data, String nomeCliente, TipoContrato tipoContrato) {
		this.data = data;
		this.nomeCliente = nomeCliente;
		this.tipoContrato = tipoContrato;
	}

	public void avanca() {
		if (tipoContrato == TipoContrato.NOVO) {
			tipoContrato = TipoContrato.EM_ANDAMENTO;
		} else if (tipoContrato == TipoContrato.EM_ANDAMENTO) {
			tipoContrato = TipoContrato.ACERTADO;
		} else if (tipoContrato == TipoContrato.ACERTADO) {
			tipoContrato = TipoContrato.CONCLUIDO;
		}
	}

	public Estado salvaEstado() {
		return new Estado(new Contrato(this.data, this.nomeCliente, this.tipoContrato));
	}

	public void restaura(Estado estado) {
		this.data = estado.getEstado().getData();
		this.nomeCliente = estado.getEstado().getNomeCliente();
		this.tipoContrato = estado.getEstado().getTipoContrato();
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @return the nomeCliente
	 */
	public String getNomeCliente() {
		return nomeCliente;
	}

	/**
	 * @return the tipoContrato
	 */
	public TipoContrato getTipoContrato() {
		return tipoContrato;
	}
}
