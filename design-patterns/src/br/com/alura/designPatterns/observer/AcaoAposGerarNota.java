/**
 * 
 */
package br.com.alura.designPatterns.observer;

import br.com.alura.designPatterns.builder.NotaFiscal;

/**
 * @author eltonf
 *
 */
public interface AcaoAposGerarNota {

	void executa(NotaFiscal notaFiscal);
}
