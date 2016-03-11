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

	@Override
	public int avalia() {
		return numero;
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaNumero(this);
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}
}
