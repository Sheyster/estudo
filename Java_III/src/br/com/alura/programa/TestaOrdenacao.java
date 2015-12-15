/**
 * 
 */
package br.com.alura.programa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.alura.ContaPoupanca;

/**
 * @author eltonf
 *
 */
public class TestaOrdenacao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final ContaPoupanca c1 = new ContaPoupanca();
		c1.setNome("Elton");
		c1.setNumero(133);

		final ContaPoupanca c2 = new ContaPoupanca();
		c2.setNome("Mario");
		c2.setNumero(122);

		final ContaPoupanca c3 = new ContaPoupanca();
		c3.setNome("Adalberto");
		c3.setNumero(123);

		final List<ContaPoupanca> contas = new LinkedList<>();
		contas.add(c1);
		contas.add(c2);
		contas.add(c3);

		for (final ContaPoupanca contaPoupanca : contas) {
			System.out.println(contaPoupanca.getNome());
		}

		Collections.sort(contas);

		System.out.println("------------------------------------------");

		for (final ContaPoupanca contaPoupanca : contas) {
			System.out.println(contaPoupanca.getNome());
		}

		final List<ContaPoupanca> poupancas = new ArrayList<>();
		final Random gerador = new Random();

		for (int i = 0; i < 10; i++) {
			final ContaPoupanca poupanca = new ContaPoupanca();
			poupanca.setNumero(gerador.nextInt());
			poupancas.add(poupanca);
		}

		System.out.println("------------------------------------------");

		System.out.println(poupancas);

		// for (final ContaPoupanca contaPoupanca : poupancas) {
		// System.out.println(contaPoupanca.getNumero());
		// }
	}

}
