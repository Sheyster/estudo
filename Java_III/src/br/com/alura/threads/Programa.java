/**
 * 
 */
package br.com.alura.threads;

/**
 * @author eltonf
 *
 */
public class Programa implements Runnable {

	private int id;

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			System.out.println("Programa " + this.id + " valor:  " + i);
		}
	}

}
