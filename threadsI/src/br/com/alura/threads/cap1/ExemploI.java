/**
 * 
 */
package br.com.alura.threads.cap1;

/**
 * @author eltonf
 *
 */
public class ExemploI extends Thread {
	private String myName;

	public ExemploI(String str) {
		myName = str;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i + " " + myName);
		}
		System.out.println("DONE! " + myName);
	}
}
