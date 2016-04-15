/**
 * 
 */
package br.com.alura.threads.cap6;

import java.math.BigInteger;

import javax.swing.JTextArea;

/**
 * @author eltonf
 *
 */
public class MultiplicacaoRunnable implements Runnable {

	private JTextArea resultado;

	public MultiplicacaoRunnable(JTextArea resultado) {
		this.resultado = resultado;
	}

	@Override
	public void run() {

		try {
			while (true) {
				Multiplicacao m = Principal.fila.take();

				BigInteger calculo = new BigInteger("0");
				for (int i = 0; i < m.getValor1(); i++) {
					for (int j = 0; j < m.getValor2(); j++) {
						calculo = calculo.add(new BigInteger("1"));
					}
				}

				String texto = "Thread " + Thread.currentThread().getId() + " - " + m.getValor1() + " x "
						+ m.getValor2() + " = " + calculo.toString();
				resultado.setText(resultado.getText() + "\n" + texto);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
