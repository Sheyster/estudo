/**
 * 
 */
package br.com.alura.designpatterns.cap6;

import java.util.Calendar;

/**
 * @author eltonf
 *
 */
public class CalendarSistema implements Relogio {

	@Override
	public Calendar hoje() {
		return Calendar.getInstance();
	}
}
