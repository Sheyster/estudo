/**
 * 
 */
package br.com.alura.threads;

import java.util.HashSet;

/**
 * @author eltonf
 *
 */
public class ProduzMensagens implements Runnable {

	private int comeco;
	private int fim;
	private HashSet<String> mensagens;

	/**
	 * 
	 */
	public ProduzMensagens(int comeco, int fim, HashSet<String> mensagens) {
		this.comeco = comeco;
		this.fim = fim;
		this.mensagens = mensagens;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = comeco; i < fim; i++) {
			// synchronized (mensagens) {
			mensagens.add("Mensagem " + i);
			// }
		}
	}

}
