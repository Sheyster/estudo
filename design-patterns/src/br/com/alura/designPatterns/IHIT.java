/**
 * 
 */
package br.com.alura.designPatterns;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.designPatterns.model.Item;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class IHIT extends TemplateDeImpostoCondicional {

	@Override
	protected double minimaTaxacao(Orcamento orcamento) {
		return (orcamento.getValor() * 0.01) * orcamento.getItens().size();
	}

	@Override
	protected double maximaTaxacao(Orcamento orcamento) {
		return ((orcamento.getValor() * 0.13) + 100.0);
	}

	@Override
	protected boolean deveUsarMaximaTaxacao(Orcamento orcamento) {
		return formaSimples(orcamento);
		// return formaComplexa(orcamento);
	}

	private boolean formaSimples(Orcamento orcamento) {
		List<String> noOrcamento = new ArrayList<>();

		for (Item item : orcamento.getItens()) {
			if (noOrcamento.contains(item.getNome())) {
				return true;
			} else {
				noOrcamento.add(item.getNome());
			}
		}

		return false;
	}

	private boolean formaComplexa(Orcamento orcamento) {
		for (int i = 0; i < orcamento.getItens().size(); i++) {
			String item = orcamento.getItens().get(i).getNome();
			for (int j = i + 1; j < orcamento.getItens().size(); j++) {
				String item2 = orcamento.getItens().get(j).getNome();
				if (item2.equals(item)) {
					return true;
				}
			}
		}
		return false;
	}

}
