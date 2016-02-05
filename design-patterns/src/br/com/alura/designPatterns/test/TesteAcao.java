/**
 * 
 */
package br.com.alura.designPatterns.test;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.designPatterns.builder.ItemDaNota;
import br.com.alura.designPatterns.builder.NotaFiscal;
import br.com.alura.designPatterns.builder.NotaFiscalBuilder;
import br.com.alura.designPatterns.observer.AcaoAposGerarNota;
import br.com.alura.designPatterns.observer.EnviadorDeEmail;
import br.com.alura.designPatterns.observer.Multiplicador;
import br.com.alura.designPatterns.observer.NotaFiscalDao;

/**
 * @author eltonf
 *
 */
public class TesteAcao {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<AcaoAposGerarNota> list = new ArrayList<>();
		list.add(new EnviadorDeEmail());
		list.add(new NotaFiscalDao());
		list.add(new Multiplicador(10));
		NotaFiscalBuilder builder = new NotaFiscalBuilder(list);
		// builder.adicionaAcao(new EnviadorDeEmail());
		// builder.adicionaAcao(new NotaFiscalDao());
		// builder.adicionaAcao(new Multiplicador(10));
		// builder.adicionaAcao(new EnviadorDeSms());
		// builder.adicionaAcao(new Impressora());

		NotaFiscal notaFiscal = builder.paraEmpresa("Caelum").comCnpj("123.456.789/0001-10")
				.com(new ItemDaNota("item 1", 100.0)).com(new ItemDaNota("item 2", 200.0))
				.com(new ItemDaNota("item 3", 300.0)).comObservacao("entregar notaFiscal pessoalmente").constroi();
	}

}
