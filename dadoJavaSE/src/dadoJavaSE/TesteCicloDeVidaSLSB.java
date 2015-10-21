package dadoJavaSE;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.k19.sessionbeans.LancadorDeDado;

public class TesteCicloDeVidaSLSB {

	public static void main(String[] args) throws NamingException {
		InitialContext ic = new InitialContext();
		
		for (int i = 0; i < 100; i++) {
			final LancadorDeDado lancadorDeDado = (LancadorDeDado) ic.lookup("java:global/dadoWeb/LancadorDeDadoBean");
			
			Thread thread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						System.out.println(lancadorDeDado.lanca());
					}
				}
			});
			thread.start();
		}
	}
}
