/**
 * 
 */
package dadoJavaSE;

import javax.naming.InitialContext;

import br.com.k19.sessionbeans.LancadorDeDado;

/**
 * @author TON
 *
 */
public class TesteDeAcesso {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		InitialContext ic = new InitialContext();
		
		LancadorDeDado lancadorDeDado = (LancadorDeDado) ic.lookup("java:global/dadoWeb/LancadorDeDadoBean");
		
		System.out.println(lancadorDeDado.lanca());
	}

}
