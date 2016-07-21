/**
 * 
 */
package br.com.alura.designPatterns.state;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class Aprovado implements EstadoDeUmOrcamento {
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
			orcamento.setValor(orcamento.getValor() - (orcamento.getValor() * 0.02));
			descontoAplicado = true;
		} else {
			throw new RuntimeException("Desconto j� aplicado!");
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
		throw new RuntimeException("Or�amento j� est� no estado de aprovado!");
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
		throw new RuntimeException("Or�amentos em aprova��o n�o podem ser reprovado!");
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
		orcamento.setEstadoAtual(new Finalizado());
	}

}
