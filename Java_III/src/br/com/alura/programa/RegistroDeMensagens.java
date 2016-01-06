/**
 * 
 */
package br.com.alura.programa;

import java.util.HashSet;

import br.com.alura.threads.ProduzMensagens;

/**
 * @author eltonf
 *
 */
public class RegistroDeMensagens {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		HashSet<String> mensagens = new HashSet<>();

		Thread t1 = new Thread(new ProduzMensagens(0, 10000, mensagens));
		Thread t2 = new Thread(new ProduzMensagens(10000, 20000, mensagens));
		Thread t3 = new Thread(new ProduzMensagens(20000, 30000, mensagens));

		t1.start();
		t2.start();
		t3.start();

		// faz com que a thread que roda o main aguarde o fim dessas
		t1.join();
		t2.join();
		t3.join();

		System.out.println("Threds produtoras de mensagens finalizadas");

		// verifica se todas as mensagens foram guardadas
		for (int i = 0; i < 15000; i++) {
			if (!mensagens.contains("Mensagem " + i)) {
				throw new IllegalStateException("Não deveria ter null aqui dentro");
			}

			System.out.println("Fim da exeução com sucesso");
		}
	}

}
