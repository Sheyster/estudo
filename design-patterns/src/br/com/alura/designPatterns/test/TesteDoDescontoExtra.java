/**
 * 
 */
package br.com.alura.designPatterns.test;

import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class TesteDoDescontoExtra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Orcamento reforma = new Orcamento(500.0);

		reforma.aplicaDescontoExtra();
		System.out.println(reforma.getValor()); // Imprime 475,00 pois descontou
												// 5%

		reforma.aplicaDescontoExtra();
		System.out.println(reforma.getValor()); // Imprime 475,00 pois descontou
												// 5%

		reforma.aprova(); // Aprova nota!

		reforma.aplicaDescontoExtra();
		System.out.println(reforma.getValor()); // Imprime 465,50 pois descontou
												// 2%

		reforma.finaliza();

		reforma.aplicaDescontoExtra(); // Lança exceção
	}

}
