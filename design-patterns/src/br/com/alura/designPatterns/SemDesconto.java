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
public class SemDesconto implements Desconto {

	@Override
	public double desconta(Orcamento orcamento) {
		return 0;
	}

	@Override
	public void setProximo(Desconto proximo) {
		// Não faz nada
	}

}
