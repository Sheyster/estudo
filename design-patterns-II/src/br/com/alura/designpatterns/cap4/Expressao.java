/**
 * 
 */
package br.com.alura.designpatterns.cap4;

/**
 * @author eltonf
 *
 */
public interface Expressao {

	int avalia();

	void aceita(Visitor visitor);
}
