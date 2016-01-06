/**
 * 
 */
package br.com.alura.programa;

import java.util.HashSet;
import java.util.Set;

import br.com.alura.Conta;
import br.com.alura.ContaCorrente;

/**
 * @author eltonf
 *
 */
public class TestaContaHashSet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final Set<Conta> contas = new HashSet<>();

		final ContaCorrente cc1 = new ContaCorrente();
		cc1.setNumero(123);

		final ContaCorrente cc2 = new ContaCorrente();
		cc2.setNumero(123);

		contas.add(cc1);
		contas.add(cc2);

		for (final Conta conta : contas) {
			System.out.println(conta.getNumero());
		}
	}

}
