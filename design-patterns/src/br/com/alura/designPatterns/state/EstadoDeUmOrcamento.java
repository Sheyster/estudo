/**
 * 
 */
package br.com.alura.designPatterns.state;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public interface EstadoDeUmOrcamento {

	void aplicaDescontoExtra(Orcamento orcamento);

	void aprova(Orcamento orcamento);

	void reprova(Orcamento orcamento);

	void finaliza(Orcamento orcamento);
}
