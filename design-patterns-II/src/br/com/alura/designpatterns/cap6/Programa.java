/**
 * 
 */
package br.com.alura.designpatterns.cap6;

import java.io.IOException;

/**
 * @author eltonf
 *
 */
public class Programa {

	public static void main(String[] args) throws IOException {
		Relogio relogio = new CalendarSistema();
		relogio.hoje();
	}
}
