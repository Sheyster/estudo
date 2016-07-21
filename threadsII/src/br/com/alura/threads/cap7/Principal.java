/**
 * 
 */
package br.com.alura.threads.cap7;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static ThreadLocal<String> usuarioCorrente = new ThreadLocal<>();

	public static void main(String[] args) {
		new Thread(new ProcessamentoUsuario("guerra")).start();
		new Thread(new ProcessamentoUsuario("ronaldo")).start();
		new Thread(new ProcessamentoUsuario("maria")).start();
		new Thread(new ProcessamentoUsuario("beatriz")).start();
		new Thread(new ProcessamentoUsuario("roberta")).start();

	}

}
