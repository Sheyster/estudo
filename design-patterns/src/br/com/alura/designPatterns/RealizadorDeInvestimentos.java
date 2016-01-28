/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.interfaces.Investimento;
import br.com.alura.designPatterns.model.Conta;

/**
 * @author eltonf
 *
 */
public class RealizadorDeInvestimentos {

	public void realiza(Conta conta, Investimento investimento) {
		double resultado = investimento.calcula(conta);

		conta.deposita(resultado * 0.75);
		System.out.println("Novo saldo: " + conta.getSaldo());
	}
}
