/**
 * 
 */
package br.com.caelum.empresa.modelo;

/**
 * @author eltonf
 *
 */
public class PessoaJuridica extends Pessoa {

	private String cnpj;

	/**
	 * @param cnpj
	 */
	public PessoaJuridica(String cnpj) {
		super();
		this.cnpj = cnpj;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

}
