/**
 * 
 */
package br.com.alura.designpatterns.cap7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eltonf
 *
 */
public class FilaDeTrabalho {

	private List<Comando> comandos;

	/**
	 * 
	 */
	public FilaDeTrabalho() {
		comandos = new ArrayList<>();
	}

	public void adiciona(Comando comando) {
		comandos.add(comando);
	}

	public void processa() {
		for (Comando comando : comandos) {
			comando.executa();
		}
	}
}
