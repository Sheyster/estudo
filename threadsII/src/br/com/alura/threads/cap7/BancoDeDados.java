/**
 * 
 */
package br.com.alura.threads.cap7;

/**
 * @author eltonf
 *
 */
public class BancoDeDados {

	public static void grava() {
		String usuario = Principal.usuarioCorrente.get();
		System.out.println("Thread " + Thread.currentThread().getId() + "- usuário " + usuario);
	}
}
