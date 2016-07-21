/**
 * 
 */
package br.com.alura.designPatterns.builder;

/**
 * @author eltonf
 *
 */
public class ItemDaNotaBuilder {

	private String descricao;
	private double valor;

	public ItemDaNota constroi() {
		return new ItemDaNota(descricao, valor);
	}

	public ItemDaNotaBuilder comDescricao(String descricao) {
		this.descricao = descricao;
		return this;
	}

	public ItemDaNotaBuilder comValor(double valor) {
		this.valor = valor;
		return this;
	}
}
