package br.com.alura;

public class ContaPoupanca extends Conta implements Comparable<ContaPoupanca> {

	@Override
	public void atualiza(double taxa) {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(ContaPoupanca o) {
		return this.nome.compareTo(o.nome);
	}

}