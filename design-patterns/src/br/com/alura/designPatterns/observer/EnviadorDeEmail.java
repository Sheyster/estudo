/**
 * 
 */
package br.com.alura.designPatterns.observer;

import br.com.alura.designPatterns.builder.NotaFiscal;

/**
 * @author eltonf
 *
 */
public class EnviadorDeEmail implements AcaoAposGerarNota {

	public void executa(NotaFiscal fiscal) {
		System.out.println("enviado por e-mail");
	}
}
