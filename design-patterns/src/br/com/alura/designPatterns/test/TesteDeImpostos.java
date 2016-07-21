/**
 * 
 */
package br.com.alura.designPatterns.test;

import br.com.alura.designPatterns.ICCC;
import br.com.alura.designPatterns.ICMS;
import br.com.alura.designPatterns.ISS;
import br.com.alura.designPatterns.interfaces.Imposto;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class TesteDeImpostos {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Imposto icms = new ICMS();
		Imposto iss = new ISS();
		Imposto iccc = new ICCC();

		Orcamento orcamento = new Orcamento(1000.0);

		// CalculadorDeImposto calcula = new CalculadorDeImposto();

		double resultado = icms.calcula(orcamento);
		System.out.println(resultado);

		// calcula.realizaCalculo(orcamento, icms);
		//
		// calcula.realizaCalculo(orcamento, iss);
		//
		// calcula.realizaCalculo(orcamento, iccc);
	}

}
