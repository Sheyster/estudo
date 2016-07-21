/**
 * 
 */
package br.com.caelum.empresa.modelo;

/**
 * @author eltonf
 *
 */
public class PessoaFisica {
	private DadosPessoais dadosPessoais = new DadosPessoais();

	private String cpf;

	/**
	 * @return the cpf
	 */
	public String getCpf() {
		return cpf;
	}

	/**
	 * @param cpf
	 *            the cpf to set
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	/**
	 * @return
	 * @see br.com.caelum.empresa.modelo.DadosPessoais#getNome()
	 */
	public String getNome() {
		return dadosPessoais.getNome();
	}

	/**
	 * @param nome
	 * @see br.com.caelum.empresa.modelo.DadosPessoais#setNome(java.lang.String)
	 */
	public void setNome(String nome) {
		dadosPessoais.setNome(nome);
	}

	/**
	 * @return
	 * @see br.com.caelum.empresa.modelo.DadosPessoais#getEndereco()
	 */
	public String getEndereco() {
		return dadosPessoais.getEndereco();
	}

	/**
	 * @param endereco
	 * @see br.com.caelum.empresa.modelo.DadosPessoais#setEndereco(java.lang.String)
	 */
	public void setEndereco(String endereco) {
		dadosPessoais.setEndereco(endereco);
	}

	/**
	 * @return
	 * @see br.com.caelum.empresa.modelo.DadosPessoais#getEmail()
	 */
	public String getEmail() {
		return dadosPessoais.getEmail();
	}

	/**
	 * @param email
	 * @see br.com.caelum.empresa.modelo.DadosPessoais#setEmail(java.lang.String)
	 */
	public void setEmail(String email) {
		dadosPessoais.setEmail(email);
	}

}
