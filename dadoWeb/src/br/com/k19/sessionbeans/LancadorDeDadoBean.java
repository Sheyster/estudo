package br.com.k19.sessionbeans;

import java.util.Random;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {

	private Random gerador = new Random();
	
	@Override
	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}
	
}
// Este codigo mostra o funcionanto de um EBJ 3.1 onde não temos a anotação de @Local e nem a interface
//@Stateless
//public class LancadorDeDadoBean {
//	private Random gerador = new Random();
//	
//	public int lanca(){
//		return this.gerador.nextInt(6) + 1;
//	}
//}
