/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.interfaces.Imposto;
import br.com.alura.designPatterns.model.Item;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class IKCV extends TemplateDeImpostoCondicional {

	public IKCV() {
		super();
	}

	public IKCV(Imposto outroImposto) {
		super(outroImposto);
	}

	/**
	 * @param orcamento
	 * @return
	 */
	private boolean temItemMaiorQue100ReaisNo(Orcamento orcamento) {
		for (Item item : orcamento.getItens()) {
			if (item.getValor() > 100) {
				return true;
			}
		}
		return false;
	}

	@Override
	public double minimaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.06 + calculoDoOutroImposto(orcamento);
	}

	@Override
	public double maximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() * 0.10 + calculoDoOutroImposto(orcamento);
	}

	@Override
	public boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return orcamento.getValor() > 500 && temItemMaiorQue100ReaisNo(orcamento);
	}

}
