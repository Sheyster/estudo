/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.interfaces.Imposto;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public abstract class TemplateDeImpostoCondicional implements Imposto {

	@Override
	public final double calcula(Orcamento orcamento) {
		if (deveUsarMaximaTaxacao(orcamento)) {
			return maximaTaxacao(orcamento);
		} else {
			return minimaTaxacao(orcamento);
		}
	}

	/**
	 * @param orcamento
	 * @return
	 */
	protected abstract double minimaTaxacao(Orcamento orcamento);

	/**
	 * @param orcamento
	 * @return
	 */
	protected abstract double maximaTaxacao(Orcamento orcamento);

	/**
	 * @param orcamento
	 * @return
	 */
	protected abstract boolean deveUsarMaximaTaxacao(Orcamento orcamento);

}
