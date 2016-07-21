/**
 * 
 */
package br.com.alura.designPatterns.builder;

/**
 * @author eltonf
 *
 */
public class ItemDaNota {

	private String descricao;
	private double valor;

	/**
	 * @param descricao
	 * @param valor
	 */
	public ItemDaNota(String descricao, double valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}

}
