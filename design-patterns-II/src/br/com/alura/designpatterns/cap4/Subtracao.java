/**
 * 
 */
package br.com.alura.designpatterns.cap4;

/**
 * @author eltonf
 *
 */
public class Subtracao implements Expressao {

	private Expressao esquerda;
	private Expressao direita;

	public Subtracao(Expressao esquerda, Expressao direita) {
		this.esquerda = esquerda;
		this.direita = direita;

	}

	@Override
	public int avalia() {
		int resultadoEsquerda = this.esquerda.avalia();
		int resultadoDireita = this.direita.avalia();
		return resultadoEsquerda - resultadoDireita;
	}

	@Override
	public void aceita(Visitor visitor) {
		visitor.visitaSubtracao(this);
	}

	/**
	 * @return the esquerda
	 */
	public Expressao getEsquerda() {
		return esquerda;
	}

	/**
	 * @return the direita
	 */
	public Expressao getDireita() {
		return direita;
	}
}
