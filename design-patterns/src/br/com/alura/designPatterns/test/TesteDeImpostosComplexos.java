/**
 * 
 */
package br.com.alura.designPatterns.test;

import br.com.alura.designPatterns.ICMS;
import br.com.alura.designPatterns.ISS;
import br.com.alura.designPatterns.ImpostoMuitoAlto;
import br.com.alura.designPatterns.interfaces.Imposto;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class TesteDeImpostosComplexos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Imposto iss = new ISS(new ICMS());
		Imposto icms = new ICMS();
		Imposto impostoAlto = new ImpostoMuitoAlto(new ICMS());

		Orcamento orcamento = new Orcamento(500.0);

		double valor = iss.calcula(orcamento);

		System.out.println(valor);

		double valor2 = icms.calcula(orcamento);

		System.out.println(valor2);

		double valor3 = impostoAlto.calcula(orcamento);

		System.out.println(valor3);
	}

}
