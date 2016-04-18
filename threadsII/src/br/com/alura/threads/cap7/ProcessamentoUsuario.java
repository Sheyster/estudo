/**
 * 
 */
package br.com.alura.threads.cap7;

/**
 * @author eltonf
 *
 */
public class ProcessamentoUsuario implements Runnable {

	private String usuario;

	public ProcessamentoUsuario(String usuario) {
		this.usuario = usuario;
	}

	@Override
	public void run() {
		System.out.println("Thread " + Thread.currentThread().getId() + "- usuário " + usuario);
		Principal.usuarioCorrente.set(usuario);
		System.out.println("Thread " + Thread.currentThread().getId() + "- colocado no threadLocal ");
		RegraDeNegocio.executa();
	}

}
