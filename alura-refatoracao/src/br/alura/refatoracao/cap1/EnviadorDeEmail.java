/**
 * 
 */
package br.alura.refatoracao.cap1;

/**
 * @author eltonf
 *
 */
public class EnviadorDeEmail {

	/**
	 * @param nf
	 */
	public void enviaEmail(NotaFiscal nf) {
		String msgDoEmail = "Caro cliente,<br/>";
		msgDoEmail += "É com prazer que lhe avisamos que sua nota fiscal foi " + "gerada no valor de "
				+ nf.getValorLiquido() + ".<br/>";
		msgDoEmail += "Acesse o site da prefeitura e faça o download.<br/><br/>";
		msgDoEmail += "Obrigado!";

		System.out.println(msgDoEmail);
	}
}
