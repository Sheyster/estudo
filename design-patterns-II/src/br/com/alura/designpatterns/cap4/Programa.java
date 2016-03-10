/**
 * 
 */
package br.com.alura.designpatterns.cap4;

/**
 * @author eltonf
 *
 */
public class Programa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Expressao esquerda = new Subtracao(new Numero(10), new Numero(5));
		Expressao direita = new Soma(new Numero(2), new Numero(10));

		Expressao conta = new Soma(esquerda, direita);

		System.out.println(conta.avalia());

		Expressao esquerda2 = new Multiplicacao(new Numero(10), new Numero(5));
		Expressao direita2 = new Divisao(new Numero(10), new Numero(2));

		Expressao conta2 = new Multiplicacao(esquerda2, direita2);

		System.out.println(conta2.avalia());

		Expressao conta3 = new RaizQuadrada(new Numero(25));
		System.out.println(conta3.avalia());
	}

}
