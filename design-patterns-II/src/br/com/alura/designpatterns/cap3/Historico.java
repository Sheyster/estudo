/**
 * 
 */
package br.com.alura.designpatterns.cap3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author eltonf
 *
 */
public class Historico {

	private List<Estado> estadosSalvos = new ArrayList<>();

	public Estado getEstadoSalvo(int index) {
		return estadosSalvos.get(index);
	}

	public void adiciona(Estado estado) {
		estadosSalvos.add(estado);
	}
}
