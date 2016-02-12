/**
 * 
 */
package br.com.caelum.empresa.modelo;

import java.util.Calendar;

/**
 * @author eltonf
 *
 */
public class Gasto {

	private double valor;
	private String tipo;
	private Funcionario funcionario;
	private Calendar data;
	private boolean pagoEmDinheiro;

	/**
	 * @param valor
	 * @param tipo
	 * @param funcionario
	 * @param data
	 * @param pagoEmDinheiro
	 */
	public Gasto(double valor, String tipo, Funcionario funcionario, Calendar data, boolean pagoEmDinheiro) {
		super();
		this.valor = valor;
		this.tipo = tipo;
		this.funcionario = funcionario;
		this.data = data;
		this.pagoEmDinheiro = pagoEmDinheiro;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Valor: " + valor + ", data: " + data + " e tipo: " + tipo;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the funcionario
	 */
	public Funcionario getFuncionario() {
		return funcionario;
	}

	/**
	 * @param funcionario
	 *            the funcionario to set
	 */
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * @return the data
	 */
	public Calendar getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(Calendar data) {
		this.data = data;
	}

	/**
	 * @return the pagoEmDinheiro
	 */
	public boolean getPagoEmDinheiro() {
		return pagoEmDinheiro;
	}

	/**
	 * @param pagoEmDinheiro
	 *            the pagoEmDinheiro to set
	 */
	public void setPagoEmDinheiro(boolean pagoEmDinheiro) {
		this.pagoEmDinheiro = pagoEmDinheiro;
	}

}
