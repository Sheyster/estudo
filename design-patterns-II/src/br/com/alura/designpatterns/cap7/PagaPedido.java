/**
 * 
 */
package br.com.alura.designpatterns.cap7;

/**
 * @author eltonf
 *
 */
public class PagaPedido implements Comando {

	private Pedido pedido;

	/**
	 * 
	 */
	public PagaPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	@Override
	public void executa() {
		this.pedido.paga();
	}
}
