/**
 * 
 */
package br.com.alura.threads;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author eltonf
 *
 */
public class TrataEmParalelo implements Runnable {

	private Socket cliente;

	public TrataEmParalelo(Socket cliente) {
		this.cliente = cliente;
	}

	@Override
	public void run() {
		try {
			Scanner s = new Scanner(this.cliente.getInputStream());
			while (s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
