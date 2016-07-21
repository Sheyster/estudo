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
public class Arrojado implements Investimento {

	private Random random;

	/**
	 * 
	 */
	public Arrojado() {
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
		int chute = random.nextInt(10);
		if (chute >= 0 && chute <= 1) {
			return conta.getSaldo() * 0.5;
		} else if (chute >= 2 && chute <= 4) {
			return conta.getSaldo() * 0.3;
		} else {
			return conta.getSaldo() * 0.006;
		}
	}

}
