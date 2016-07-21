/**
 * 
 */
package br.com.alura.designpatterns.cap3;

/**
 * @author eltonf
 *
 */
public class Estado {

	private Contrato contrato;

	public Estado(Contrato contrato) {
		this.contrato = contrato;
	}

	public Contrato getEstado() {
		return contrato;
	}
}
