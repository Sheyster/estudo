/**
 * 
 */
package br.com.alura.programa;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.Conta;
import br.com.alura.ContaCorrente;
import br.com.alura.exceptions.ValorInvalidoException;

/**
 * @author eltonf
 *
 */
public class TesteMap {

	/**
	 * @param args
	 * @throws ValorInvalidoException
	 */
	public static void main(String[] args) throws ValorInvalidoException {
		final Conta c1 = new ContaCorrente();
		c1.deposita(10000);

		final Conta c2 = new ContaCorrente();
		c2.deposita(3000);

		final Map<String, Conta> mapdaDeContas = new HashMap<String, Conta>();
		mapdaDeContas.put("diretor", c1);
		mapdaDeContas.put("gerente", c2);

		final Conta contaDoDiretor = mapdaDeContas.get("diretor");
		System.out.println(contaDoDiretor.getSaldo());
	}

}
