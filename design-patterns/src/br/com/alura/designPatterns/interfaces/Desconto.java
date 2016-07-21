/**
 * 
 */
package br.com.alura.designPatterns.interfaces;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public interface Desconto {

	double desconta(Orcamento orcamento);

	void setProximo(Desconto proximo);
}
