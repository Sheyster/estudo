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
public class ICCC extends Imposto {

	private static final double TRES_MIL = 3000.0;
	private static final double MIL = 1000.0;

	/**
	 * 
	 */
	public ICCC() {
	}

	/**
	 * @param outroImposto
	 */
	public ICCC(Imposto outroImposto) {
		super(outroImposto);
	}

	@Override
	public double calcula(Orcamento orcamento) {
		double valor = 0;

		if (orcamento.getValor() < MIL) {
			valor = orcamento.getValor() * 0.05;
		} else if (orcamento.getValor() >= MIL && orcamento.getValor() < TRES_MIL) {
			valor = orcamento.getValor() * 0.07;
		} else if (orcamento.getValor() >= TRES_MIL) {
			valor = orcamento.getValor() * 0.08;
		}
		return valor;
	}
}
