package br.com.alura;

import br.com.alura.exceptions.ValorInvalidoException;

public abstract class Conta {
	protected double saldo;
	private String nome;

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
}