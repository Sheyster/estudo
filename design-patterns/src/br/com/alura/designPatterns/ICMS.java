/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class ICMS implements Imposto {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.Imposto#calcula(br.com.alura.designPatterns.
	 * model.Orcamento)
	 */
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.05 + 50.0;
	}

}
