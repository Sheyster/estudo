/**
 * 
 */
package br.com.alura.threads;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author eltonf
 *
 */
public class Programa {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		new ExemploI("testando").start();

		ServerSocket server = new ServerSocket(12345);
		while (true) {
			Socket cliente = server.accept();
			Thread t = new Thread(new TrataEmParalelo(cliente));
			t.start();
		}
	}

}
