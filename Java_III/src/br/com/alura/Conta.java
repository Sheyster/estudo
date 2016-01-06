package br.com.alura;

import br.com.alura.exceptions.ValorInvalidoException;

public abstract class Conta {
	protected double saldo;
	protected String nome;
	protected int numero;

	public double getSaldo() {
		return this.saldo;
	}

	/**
	 * Método responsável pelo depósito na conta do cliente.
	 * 
	 * @param valor
	 *            Valor a ser creditado.
	 * @throws ValorInvalidoException
	 *             Caso receba um número negativo.
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
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}

	/**
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return this.numero;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// return "Esse objeto é uma conta com saldo R$" + this.saldo;
		return "Esse objeto é o número da conta: " + this.numero;
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#hashCode()
	// */
	// @Override
	// public int hashCode() {
	// final int prime = 31;
	// int result = 1;
	// result = prime * result + this.numero;
	// return result;
	// }
	//
	// /*
	// * (non-Javadoc)
	// *
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj) {
	// return true;
	// }
	// if (obj == null) {
	// return false;
	// }
	// if (this.getClass() != obj.getClass()) {
	// return false;
	// }
	// final Conta other = (Conta) obj;
	// if (this.numero != other.numero) {
	// return false;
	// }
	// return true;
	// }

	// /* (non-Javadoc)
	// * @see java.lang.Object#equals(java.lang.Object)
	// */
	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Conta other = (Conta) obj;
	// if (nome == null) {
	// if (other.nome != null)
	// return false;
	// } else if (!nome.equals(other.nome))
	// return false;
	// if (numero != other.numero)
	// return false;
	// return true;
	// }

}