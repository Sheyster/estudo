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
public class ICMS extends Imposto {
	/**
	 * 
	 */
	public ICMS() {
	}

	/**
	 * @param outroImposto
	 */
	public ICMS(Imposto outroImposto) {
		super(outroImposto);
		// TODO Auto-generated constructor stub
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
		return orcamento.getValor() * 0.05 + 50.0 + calculoDoOutroImposto(orcamento);
	}

}
