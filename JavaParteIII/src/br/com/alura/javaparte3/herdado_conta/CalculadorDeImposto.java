package br.com.alura.javaparte3.herdado_conta;

public class CalculadorDeImposto {

	private double totalImposto;

	public void registra(Tributavel t) {
		double valor = t.getValorImposto();
		this.totalImposto += valor;
	}

	public double getTotalImposto() {
		return totalImposto;
	}

}
