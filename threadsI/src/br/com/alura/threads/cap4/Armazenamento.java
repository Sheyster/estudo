/**
 * 
 */
package br.com.alura.threads.cap4;

/**
 * @author eltonf
 *
 */
public class Armazenamento {

	public static Armazenamento instancia = new Armazenamento();

	private String[] lista = new String[1000];

	private int contador = 0;

	public synchronized void adicionaElemento(String elemento) {
		lista[contador] = elemento;
		contador++;
		if (contador == lista.length) {
			this.notify();
		}
	}

	public String[] recuperaLista() {
		return lista;
	}

	/**
	 * @return the contador
	 */
	public int getContador() {
		return contador;
	}

}
