package br.com.alura.javaparte3.herdado_conta;

public class SeguroDeVida implements Tributavel {

	@Override
	public double getValorImposto() {
		return 42;
	}

}
