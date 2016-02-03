/**
 * 
 */
package br.com.alura.designPatterns.state;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class Reprovado implements EstadoDeUmOrcamento {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.com.alura.designPatterns.state.EstadoDeUmOrcamento#aplicaDescontoExtra
	 * (br.com.alura.designPatterns.model.Orcamento)
	 */
	@Override
	public void aplicaDescontoExtra(Orcamento orcamento) {
		throw new RuntimeException("Or�amentos reprovados n�o recebem desconto extra!");
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
		throw new RuntimeException("Or�amentos reprovados n�o podem ser aprovados!");
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
		throw new RuntimeException("Or�amentos reprovados n�o podem ser reprovados novamente!");
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
