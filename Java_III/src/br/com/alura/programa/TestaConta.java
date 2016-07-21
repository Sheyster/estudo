/**
 * 
 */
package br.com.alura.programa;

import br.com.alura.Conta;
import br.com.alura.ContaCorrente;

/**
 * @author eltonf
 *
 */
public class TestaConta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Conta conta = new ContaCorrente();
		final Conta conta2 = new ContaCorrente();
		conta.setNumero(10);
		conta2.setNumero(10);
		conta.setNome("Maria");
		conta2.setNome("Marta");

		if (conta == conta2) {
			System.out.println("Contas iguais");
		} else {
			System.out.println("Contas diferentes");
		}

		if (conta.equals(conta2)) {
			System.out.println("Contas iguais");
		} else {
			System.out.println("Contas diferentes");
		}
	}

}
