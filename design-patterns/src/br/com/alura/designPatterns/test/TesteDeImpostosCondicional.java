/**
 * 
 */
package br.com.alura.designPatterns.test;

import br.com.alura.designPatterns.ICPP;
import br.com.alura.designPatterns.IKCV;
import br.com.alura.designPatterns.TemplateDeImpostoCondicional;
import br.com.alura.designPatterns.model.Item;
import br.com.alura.designPatterns.model.Orcamento;

/**
 * @author eltonf
 *
 */
public class TesteDeImpostosCondicional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TemplateDeImpostoCondicional icpp = new ICPP();
		TemplateDeImpostoCondicional ikcb = new IKCV();

		Orcamento orcamento = new Orcamento(1000.00);
		orcamento.adicionaItem(new Item("CANETA", 50.0));
		orcamento.adicionaItem(new Item("LAPIS", 150.0));

		double resultado = ikcb.calcula(orcamento);
		System.out.println(resultado);

		double resultado2 = icpp.calcula(orcamento);
		System.out.println(resultado2);
	}

}
