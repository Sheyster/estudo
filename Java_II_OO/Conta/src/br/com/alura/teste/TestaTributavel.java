package br.com.alura.teste;

import br.com.alura.ContaCorrente;
import br.com.alura.face.Tributavel;

public class TestaTributavel {

	public static void main(String[] args) {
		final ContaCorrente cc = new ContaCorrente();
		// cc.deposita(100);
		System.out.println(cc.calculaTributos());

		final Tributavel t = cc;
		System.out.println(t.calculaTributos());

		System.err.println(cc.getSaldo());
	}
}
