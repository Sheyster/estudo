/**
 * 
 */
package br.com.alura.designPatterns;

import java.util.Random;

import br.com.alura.designPatterns.interfaces.Investimento;
import br.com.alura.designPatterns.model.Conta;

/**
 * @author eltonf
 *
 */
public class Moderado implements Investimento {
	private Random random;

	/**
	 * 
	 */
	public Moderado() {
		this.random = new Random();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.alura.designPatterns.Investimento#calcula(br.com.alura.
	 * designPatterns.model.Conta)
	 */
	@Override
	public double calcula(Conta conta) {
		if (random.nextInt(2) == 0) {
			return conta.getSaldo() * 0.025;
		} else {
			return conta.getSaldo() * 0.027;
		}
	}

}
