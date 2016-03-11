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

	@Override
	public int avalia() {
		double resultadoEsquerda = this.numero.avalia();
		return (int) Math.sqrt(resultadoEsquerda);
	}

	@Override
	public void aceita(Visitor visitor) {

	}

}
