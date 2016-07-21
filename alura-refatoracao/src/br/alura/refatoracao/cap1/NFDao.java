/**
 * 
 */
package br.alura.refatoracao.cap1;

/**
 * @author eltonf
 *
 */
public class NFDao {

	/**
	 * @param nf
	 */
	public void salvaNoBanco(NotaFiscal nf) {
		String sql = "insert into notafiscal (cliente, valor)" + "values (?," + nf.getValorLiquido() + ")";

		System.out.println("Salvando no banco" + sql);
	}

}
