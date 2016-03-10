/**
 * 
 */
package br.com.alura.designpatterns.cap4;

/**
 * @author eltonf
 *
 */
public class Numero implements Expressao {

	private int numero;

	public Numero(int numero) {
		this.numero = numero;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.alura.designpatterns.cap4.Expressao#avalia()
	 */
	@Override
	public int avalia() {
		return numero;
	}
}
