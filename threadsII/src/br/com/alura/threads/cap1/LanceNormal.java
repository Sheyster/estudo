/**
 * 
 */
package br.com.alura.threads.cap1;

/**
 * @author eltonf
 *
 */
public class LanceNormal implements Runnable {

	private Leilao leilao;
	private Incremento incremento;

	public LanceNormal(Incremento incremento, Leilao leilao) {
		this.incremento = incremento;
		this.leilao = leilao;
	}

	@Override
	public void run() {
		System.out.println("Iniciando lance normal");
		synchronized (incremento) {
			int valorIncremento = incremento.get();
			synchronized (leilao) {
				leilao.darLance(valorIncremento);
				System.out.println("O valor do produto agora é " + leilao.getCorrente());
			}
		}
	}

}
