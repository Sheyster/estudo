/**
 * 
 */
package br.com.caelum.empresa;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.empresa.modelo.Gasto;

/**
 * @author eltonf
 *
 */
public class FiltradorDeGastosEspeciais {

	private double limite;

	/**
	 * @param limite
	 */
	FiltradorDeGastosEspeciais(double limite) {
		super();
		this.limite = limite;
	}

	public List<Gasto> filtraGastosGrandes(List<Gasto> gastos) {
		List<Gasto> gastosAcimaDoLimite = new ArrayList<Gasto>();
		for (Gasto gasto : gastos) {
			if (gasto.getValor() >= this.limite) {
				gastosAcimaDoLimite.add(gasto);
			}
		}
		return gastosAcimaDoLimite;
	}
}
