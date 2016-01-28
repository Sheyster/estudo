/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.interfaces.Imposto;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class CalculadorDeImposto {

	public void realizaCalculo(Orcamento orcamento, Imposto imposto) {
		double valor = imposto.calcula(orcamento);

		System.out.println(valor);
	}
}
