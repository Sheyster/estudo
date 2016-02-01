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
public class ISS extends Imposto {

	/**
	 * @param outroImposto
	 */
	public ISS(Imposto outroImposto) {
		super(outroImposto);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	public ISS() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.Imposto#calcula(br.com.alura.designPatterns.
	 * model.Orcamento)
	 */
	@Override
	public double calcula(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}

}
