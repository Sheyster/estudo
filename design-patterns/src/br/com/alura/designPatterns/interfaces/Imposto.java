/**
 * 
 */
package br.com.alura.designPatterns.interfaces;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public abstract class Imposto {

	private final Imposto outroImposto;

	/**
	 * 
	 */
	public Imposto(Imposto outroImposto) {
		this.outroImposto = outroImposto;
	}

	/**
	 * 
	 */
	public Imposto() {
		this.outroImposto = null;
	}

	public abstract double calcula(Orcamento orcamento);

	/**
	 * @param orcamento
	 * @return
	 */
	protected double calculoDoOutroImposto(Orcamento orcamento) {
		if (outroImposto == null) {
			return 0;
		} else {
			return outroImposto.calcula(orcamento);
		}
	}
}
