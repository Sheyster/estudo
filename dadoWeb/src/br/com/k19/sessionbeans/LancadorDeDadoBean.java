package br.com.k19.sessionbeans;

import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(LancadorDeDado.class)
public class LancadorDeDadoBean implements LancadorDeDado {

	private Random gerador = new Random();
	private static int contador;
	
	@PostConstruct
	public void inicializando(){
		synchronized (LancadorDeDadoBean.class) {
			LancadorDeDadoBean.contador++;
			System.out.println("Criando um lan�ador de dados...");
			System.out.println("Total: " + LancadorDeDadoBean.contador);
		}
	}
	
	@PreDestroy
	public void destruindo(){
		synchronized (LancadorDeDadoBean.class) {
			LancadorDeDadoBean.contador--;
			System.out.println("Destruindo um lan�ador de dados...");
			System.out.println("Total: " + LancadorDeDadoBean.contador);
		}
	}
	@Override
	public int lanca() {
		return this.gerador.nextInt(6) + 1;
	}
	
}
// Este codigo mostra o funcionanto de um EBJ 3.1 onde n�o temos a anota��o de @Local e nem a interface
//@Stateless
//public class LancadorDeDadoBean {
//	private Random gerador = new Random();
//	
//	public int lanca(){
//		return this.gerador.nextInt(6) + 1;
//	}
//}
