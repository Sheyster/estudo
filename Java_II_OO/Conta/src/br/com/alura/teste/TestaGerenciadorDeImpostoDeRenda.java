package br.com.alura.teste;

import br.com.alura.ContaCorrente;
import br.com.alura.GerenciadorDeImpostoDeRenda;
import br.com.alura.SeguroDeVida;

public class TestaGerenciadorDeImpostoDeRenda {

	public static void main(String[] args) {
		final GerenciadorDeImpostoDeRenda gerenciador = new GerenciadorDeImpostoDeRenda();

		final SeguroDeVida sv = new SeguroDeVida();
		gerenciador.adiciona(sv);

		final ContaCorrente cc = new ContaCorrente();
		// cc.deposita(1000);
		gerenciador.adiciona(cc);

		System.out.println(gerenciador.getTotal());

		System.out.println(cc.getSaldo());
		System.out.printf("O saldo é: %.2f", cc.getSaldo());
	}

}
