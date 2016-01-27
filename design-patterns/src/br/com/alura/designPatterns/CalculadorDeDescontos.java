/**
 * 
 */
package br.com.alura.designPatterns;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class CalculadorDeDescontos {

	public double calcula(Orcamento orcamento) {
		// Desconto d4 = new SemDesconto();
		Desconto d3 = new DescontoPorVendaCasada(null);
		Desconto d2 = new DescontoPorMaisDeQuinhentosReais(d3);
		Desconto d1 = new DescontoPorMaisDeCincoItens(d2);

		// d1.setProximo(d2);
		// d2.setProximo(d3);
		// d3.setProximo(d4);

		return d1.desconta(orcamento);
	}
}
