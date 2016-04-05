/**
 * 
 */
package br.com.alura.threads.cap1;

/**
 * @author eltonf
 *
 */
public class LanceIncremento implements Runnable {

	private Leilao leilao;
	private Incremento incremento;

	public LanceIncremento(Incremento incremento, Leilao leilao) {
		this.incremento = incremento;
		this.leilao = leilao;
	}

	@Override
	public void run() {
		synchronized (incremento) {
			synchronized (leilao) {
				System.out.println("Iniciando lance com incremento no leilao com valor " + leilao.getCorrente());
				incremento.dobrar();
				int valorIncremento = incremento.get();
				leilao.darLance(valorIncremento);
				System.out.println("Valor corrente do leilao " + leilao.getCorrente() + " incremento agora de "
						+ incremento.get());
			}
		}
	}
}
