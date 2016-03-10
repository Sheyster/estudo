/**
 * 
 */
package br.com.alura.designpatterns.cap4;

/**
 * @author eltonf
 *
 */
public class RaizQuadrada implements Expressao {

	private Expressao numero;

	/**
	 * 
	 */
	public RaizQuadrada(Expressao numero) {
		this.numero = numero;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.alura.designpatterns.cap4.Expressao#avalia()
	 */
	@Override
	public int avalia() {
		double resultadoEsquerda = this.numero.avalia();
		return (int) Math.sqrt(resultadoEsquerda);
	}
}
