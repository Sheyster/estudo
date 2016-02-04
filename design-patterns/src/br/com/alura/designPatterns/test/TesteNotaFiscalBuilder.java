/**
 * 
 */
package br.com.alura.designPatterns.test;

import br.com.alura.designPatterns.builder.ItemDaNota;
import br.com.alura.designPatterns.builder.ItemDaNotaBuilder;
import br.com.alura.designPatterns.builder.NotaFiscal;
import br.com.alura.designPatterns.builder.NotaFiscalBuilder;

/**
 * @author eltonf
 *
 */
public class TesteNotaFiscalBuilder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		NotaFiscalBuilder builder = new NotaFiscalBuilder();
		ItemDaNotaBuilder itemDaNotaBuilder = new ItemDaNotaBuilder();
		itemDaNotaBuilder.comDescricao("Item 1").comValor(100.0);
		ItemDaNota item1 = itemDaNotaBuilder.constroi();

		itemDaNotaBuilder.comDescricao("Item 2").comValor(200.0);
		ItemDaNota item2 = itemDaNotaBuilder.constroi();

		itemDaNotaBuilder.comDescricao("Item 3").comValor(300.0);
		ItemDaNota item3 = itemDaNotaBuilder.constroi();

		itemDaNotaBuilder.comDescricao("Item 4").comValor(300.0);
		ItemDaNota item4 = itemDaNotaBuilder.constroi();

		builder.paraEmpresa("ALURA").comCnpj("123.456.789/0001-10").com(item1).com(item2).com(item3)
				.com(item4).comObservacao("entregar nf pessoalmente");

		NotaFiscal notaFiscal = builder.controi();

		System.out.println(notaFiscal.getValorBruto());
		System.out.println(notaFiscal.getImpostos());
	}

}
