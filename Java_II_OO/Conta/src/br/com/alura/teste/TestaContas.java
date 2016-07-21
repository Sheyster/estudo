package br.com.alura.teste;

import br.com.alura.Conta;
import br.com.alura.ContaCorrente;
import br.com.alura.ContaPoupanca;
import br.com.alura.exceptions.ValorInvalidoException;

public class TestaContas {
	public static void main(String[] args) {
		// Conta c = new Conta();
		final Conta cc = new ContaCorrente();
		final Conta cp = new ContaPoupanca();

		final Conta[] c = new Conta[10];

		// c.deposita(1000);
		try {
			cc.deposita(1000);
		} catch (final ValorInvalidoException e) {
			System.out.println(e.getMessage());
		}
		// cp.deposita(1000);

		// c.atualiza(0.01);
		cc.atualiza(0.01);
		cp.atualiza(0.01);

		// System.out.println(c.getSaldo());
		System.out.println(cc.getSaldo());
		System.out.println(cp.getSaldo());

		// final List<String> lista = new ArrayList<>();
		// while (true) {
		// lista.add(new String("Kabum"));
		// System.out.println(lista.toString());
		// }

		// final String[] ss = new String[Integer.MAX_VALUE];
		// AtualizadorDeContas at = new AtualizadorDeContas(0.1);
		// at.roda(c);
		// System.out.println(c.getSaldo());
		// at.roda(cc);
		// System.out.println(cc.getSaldo());
	}
}