/**
 * 
 */
package br.com.alura.threads.cap6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * @author eltonf
 *
 */
public class ExecutaEmParalelo implements ActionListener {

	private JTextField segundo;
	private JTextField primeiro;

	public ExecutaEmParalelo(JTextField primeiro, JTextField segundo) {
		this.primeiro = primeiro;
		this.segundo = segundo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long valor1 = Long.parseLong(primeiro.getText());
		long valor2 = Long.parseLong(segundo.getText());

		Multiplicacao m = new Multiplicacao(valor1, valor2);
		try {
			Principal.fila.put(m);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}

}
