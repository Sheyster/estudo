/**
 * 
 */
package br.com.alura.designpatterns.cap4;

/**
 * @author eltonf
 *
 */
public class Divisao implements Expressao {

	private Expressao direita;
	private Expressao esquerda;

	/**
	 * 
	 */
	public Divisao(Expressao esquerda, Expressao direita) {
		this.esquerda = esquerda;
		this.direita = direita;
	}

	@Override
	public int avalia() {
		int resultadoEsquerda = this.esquerda.avalia();
		int resultadoDireita = this.direita.avalia();
		return resultadoEsquerda / resultadoDireita;
	}

	@Override
	public void aceita(Visitor visitor) {
	}

}
