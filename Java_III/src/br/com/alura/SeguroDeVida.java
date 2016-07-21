/**
 * 
 */
package br.com.alura;

import br.com.alura.face.Tributavel;

/**
 * @author eltonf
 *
 */
public class SeguroDeVida implements Tributavel{

	@Override
	public double calculaTributos() {
		return 42;
	}

}
