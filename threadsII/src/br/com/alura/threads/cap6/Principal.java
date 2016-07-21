/**
 * 
 */
package br.com.alura.threads.cap6;

import java.awt.BorderLayout;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static BlockingQueue<Multiplicacao> fila = new ArrayBlockingQueue<>(10);

	public static void main(String[] args) {

		JFrame janela = new JFrame("Multiplicação demorada");

		janela.setLayout(new BorderLayout());

		JPanel painel = new JPanel();

		JTextField primeiro = new JTextField(10);
		JTextField segundo = new JTextField(10);
		JButton botaoCalcular = new JButton(" = ");
		JTextArea resultado = new JTextArea();

		botaoCalcular.addActionListener(new ExecutaEmParalelo(primeiro, segundo));

		painel.add(primeiro);
		painel.add(new JLabel(" x "));
		painel.add(segundo);
		painel.add(botaoCalcular);

		janela.add(painel, BorderLayout.CENTER);
		janela.add(resultado, BorderLayout.SOUTH);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.pack();
		janela.setVisible(true);

		new Thread(new MultiplicacaoRunnable(resultado)).start();
		new Thread(new MultiplicacaoRunnable(resultado)).start();
		new Thread(new MultiplicacaoRunnable(resultado)).start();
	}
}
