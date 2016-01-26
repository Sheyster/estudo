/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.model.Conta;

/**
 * @author eltonf
 *
 */
public class Conservador implements Investimento {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.alura.designPatterns.Investimento#calcula(br.com.alura.
	 * designPatterns.model.Conta)
	 */
	@Override
	public double calcula(Conta conta) {
		return conta.getSaldo() * 0.008;
	}
}
