package br.com.alura;

import br.com.alura.exceptions.ValorInvalidoException;

public abstract class Conta {
	protected double saldo;
	private String nome;
	protected int numero;

	public double getSaldo() {
		return this.saldo;
	}

	/**
	 * M�todo respons�vel pelo dep�sito na conta do cliente.
	 * 
	 * @param valor
	 *            Valor a ser creditado.
	 * @throws ValorInvalidoException
	 *             Caso receba um n�mero negativo.
	 */
	public void deposita(double valor) throws ValorInvalidoException {
		if (valor < 0) {
			throw new ValorInvalidoException(valor);
		} else {
			this.saldo += valor - 0.10;
		}
	}

	public void sacar(double valor) {
		this.saldo -= valor;
	}

	public abstract void atualiza(double taxa);

	public void atualizandoConta(double valor) {
		this.saldo += valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Esse objeto � uma conta com saldo R$" + this.saldo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		final Conta outraConta = (Conta) obj;
		if (this.numero != outraConta.numero) {
			return false;
		}
		if (this.nome != outraConta.nome) {
			return false;
		}
		return true;
	}
}