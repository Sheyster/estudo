/**
 * 
 */
package br.com.alura.threads.cap5;

import java.util.concurrent.Callable;

/**
 * @author eltonf
 *
 */
public class SomaNotas implements Callable<Integer> {

	private NotaFiscal[] notas;
	private int inicio;
	private int termino;

	/**
	 * @param notas
	 * @param inicio
	 * @param termino
	 */
	public SomaNotas(NotaFiscal[] notas, int inicio, int termino) {
		this.notas = notas;
		this.inicio = inicio;
		this.termino = termino;
	}

	@Override
	public Integer call() throws Exception {
		int soma = 0;

		for (int i = inicio; i < termino; i++) {
			soma += notas[i].getTotal();
		}
		return soma;
	}

}
