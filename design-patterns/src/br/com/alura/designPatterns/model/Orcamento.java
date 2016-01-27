/**
 * 
 */
package br.com.alura.designPatterns.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author eltonf
 *
 */
public class Orcamento {

	private double valor;
	private List<Item> itens;

	public Orcamento(double valor) {
		this.valor = valor;
		this.itens = new ArrayList<>();
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

}
