/**
 * 
 */
package br.com.alura.designpatterns.cap3;

import java.util.Calendar;

/**
 * @author eltonf
 *
 */
public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Historico historico = new Historico();

		Contrato contrato = new Contrato(Calendar.getInstance(), "Mauricio", TipoContrato.NOVO);
		historico.adiciona(contrato.salvaEstado());

		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		contrato.avanca();
		historico.adiciona(contrato.salvaEstado());

		System.out.println(contrato.getTipoContrato());
		contrato.restaura(historico.getEstadoSalvo(1));
		System.out.println(contrato.getTipoContrato());

	}

}
