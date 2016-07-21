package br.com.k19.managedbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionbeans.Calculadora;

@ManagedBean
public class CalculadoraMB {

	@EJB
	private Calculadora calculadora;
	
	private double a;
	
	private double b;
	
	private double resultado;
	
	public void soma() {
		this.resultado = this.calculadora.soma(a, b);
	}

	/**
	 * @return the a
	 */
	public double getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(double a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(double b) {
		this.b = b;
	}

	/**
	 * @return the resultado
	 */
	public double getResultado() {
		return resultado;
	}

	/**
	 * @param resultado the resultado to set
	 */
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
}
