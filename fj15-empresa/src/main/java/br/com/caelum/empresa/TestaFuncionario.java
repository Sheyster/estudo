/**
 * 
 */
package br.com.caelum.empresa;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.caelum.empresa.modelo.Funcionario;
import br.com.caelum.empresa.modelo.Gasto;

/**
 * @author eltonf
 *
 */
public class TestaFuncionario {

	public static void main(String[] args) {

		Calendar dataNascimento = new GregorianCalendar(1984, 4, 28);
		Funcionario funcionario = new Funcionario("Elton", 12, dataNascimento);
		Calendar data = Calendar.getInstance();

		Gasto gasto1 = new Gasto(40, "teste", funcionario, data, false);
		Gasto gasto2 = new Gasto(40, "teste", funcionario, data, false);
		Gasto gasto3 = new Gasto(40, "teste", funcionario, data, false);

		System.out.println(gasto1);

		for (String string : args) {
			System.out.println(string);
		}
	}
}
