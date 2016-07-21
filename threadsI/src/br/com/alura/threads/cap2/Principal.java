/**
 * 
 */
package br.com.alura.threads.cap2;

/**
 * @author eltonf
 *
 */
public class Principal {

	public static void main(String[] args) {
		String procurado = "Jef";
		BuscaNome b1 = new BuscaNome("autores.txt", procurado);
		BuscaNome b2 = new BuscaNome("signatarios-octfeb2002.txt", procurado);
		BuscaNome b3 = new BuscaNome("signatarios-febmar2002.txt", procurado);

		Thread t1 = new Thread(b1);
		Thread t2 = new Thread(b2);
		Thread t3 = new Thread(b3);

		t1.start();
		t2.start();
		t3.start();

	}

}
