/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.model.Item;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class DescontoPorVendaCasada implements Desconto {

	/**
	 * 
	 */
	private static final String CANETA = "CANETA";
	/**
	 * 
	 */
	private static final String LAPIS = "LAPIS";
	private Desconto proximo;

	/**
	 * @param proximo
	 */
	DescontoPorVendaCasada(Desconto proximo) {
		this.proximo = proximo;
	}

	@Override
	public double desconta(Orcamento orcamento) {
		if (aconteceuVendaCasadaEm(orcamento)) {
			return orcamento.getValor() * 0.05;
		} else {
			return proximo.desconta(orcamento);
		}
	}

	private boolean aconteceuVendaCasadaEm(Orcamento orcamento) {
		return existe(LAPIS, orcamento) && existe(CANETA, orcamento);
	}

	@Override
	public void setProximo(Desconto proximo) {
		this.proximo = proximo;
	}

	private boolean existe(String nomeDoItem, Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getNome().equals(nomeDoItem))
				return true;
		}
		return false;
	}
}
