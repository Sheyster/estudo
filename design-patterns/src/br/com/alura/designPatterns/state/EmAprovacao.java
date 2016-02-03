/**
 * 
 */
package br.com.alura.designPatterns.state;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class EmAprovacao implements EstadoDeUmOrcamento {

	private boolean descontoAplicado = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.state.EstadoDeUmOrcamento#aplicaDescontoExtra
	 * (br.com.alura.designPatterns.model.Orcamento)
	 */
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		if (!descontoAplicado) {
			orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.05));
			descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto já aplicado!");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.state.EstadoDeUmOrcamento#aprova(br.com.alura
	 * .designPatterns.model.Orcamento)
	 */
	@Override
	public void aprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Aprovado());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.state.EstadoDeUmOrcamento#reprova(br.com.
	 * alura.designPatterns.model.Orcamento)
	 */
	@Override
	public void reprova(Orcamento orcamento) {
		orcamento.setEstadoAtual(new Reprovado());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.state.EstadoDeUmOrcamento#finaliza(br.com.
	 * alura.designPatterns.model.Orcamento)
	 */
	@Override
	public void finaliza(Orcamento orcamento) {
		throw new RuntimeException("Orçamentos em aprovação não podem ser finalizados diretamente!");
	}

}
