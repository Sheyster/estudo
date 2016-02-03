/**
 * 
 */
package br.com.alura.designPatterns.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.alura.designPatterns.state.EmAprovacao;
import br.com.alura.designPatterns.state.EstadoDeUmOrcamento;

/**
 * @author eltonf
 *
 */
public class Orcamento {

	private double valor;
	private List<Item> itens;
	private EstadoDeUmOrcamento estadoAtual;

	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<>();
		this.estadoAtual = new EmAprovacao();
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

	/**
	 * @return the itens
	 */
	public List<Item> getItens() {
		return Collections.unmodifiableList(itens);
	}

	/**
	 * @param item
	 */
	public void adicionaItem(Item item) {
		this.itens.add(item);
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}

	public void aplicaDescontoExtra() {
		estadoAtual.aplicaDescontoExtra(this);
	}

	/**
	 * @param estadoAtual
	 *            the estadoAtual to set
	 */
	public void setEstadoAtual(EstadoDeUmOrcamento estadoAtual) {
		this.estadoAtual = estadoAtual;
	}

	public void aprova() {
		estadoAtual.aprova(this);
	}

	public void reprova() {
		estadoAtual.reprova(this);
	}

	public void finaliza() {
		estadoAtual.finaliza(this);
	}
}
