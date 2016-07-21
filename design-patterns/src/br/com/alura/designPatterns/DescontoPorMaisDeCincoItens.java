/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.interfaces.Desconto;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class DescontoPorMaisDeCincoItens implements Desconto {

	private Desconto proximo;

	/**
	 * @param proximo
	 */
	DescontoPorMaisDeCincoItens(Desconto proximo) {
		this.proximo = proximo;
	}

	@Override
	public double desconta(Orcamento orcamento) {
		if (orcamento.getItens().size() > 5) {
			return orcamento.getValor() * 0.1;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}
}
