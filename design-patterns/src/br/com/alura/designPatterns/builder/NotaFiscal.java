/**
 * 
 */
package br.com.alura.designPatterns.builder;

import java.util.Calendar;
import java.util.List;

/**
 * @author eltonf
 *
 */
public class NotaFiscal {

	private String razaoSocial;
	private String CNPJ;
	private double valorBruto;
	private double impostos;
	private Calendar dataEmissao;
	private String observacao;
	private List<ItemDaNota> itens;

	/**
	 * @param razaoSocial
	 * @param CNPJ
	 * @param valorBruto
	 * @param impostos
	 * @param dataEmissao
	 * @param observacao
	 */
	public NotaFiscal(String razaoSocial, String CNPJ, double valorBruto, double impostos, Calendar dataEmissao,
			String observacao, List<ItemDaNota> itens) {
		this.razaoSocial = razaoSocial;
		this.CNPJ = CNPJ;
		this.valorBruto = valorBruto;
		this.impostos = impostos;
		this.dataEmissao = dataEmissao;
		this.observacao = observacao;
		this.itens = itens;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @return the cNPJ
	 */
	public String getCNPJ() {
		return CNPJ;
	}

	/**
	 * @return the valorBruto
	 */
	public double getValorBruto() {
		return valorBruto;
	}

	/**
	 * @return the impostos
	 */
	public double getImpostos() {
		return impostos;
	}

	/**
	 * @return the dataEmissao
	 */
	public Calendar getDataEmissao() {
		return dataEmissao;
	}

	/**
	 * @return the observacao
	 */
	public String getObservacao() {
		return observacao;
	}

	/**
	 * @return the itens
	 */
	public List<ItemDaNota> getItens() {
		return itens;
	}

}
