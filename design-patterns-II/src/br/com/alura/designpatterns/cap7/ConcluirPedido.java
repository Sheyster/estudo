/**
 * 
 */
package br.com.alura.designpatterns.cap7;

/**
 * @author eltonf
 *
 */
public class ConcluirPedido implements Comando {

	private Pedido pedido;

	public ConcluirPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public void executa() {
		this.pedido.finaliza();
	}
}
