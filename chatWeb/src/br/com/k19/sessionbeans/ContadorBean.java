package br.com.k19.sessionbeans;

import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Remote;
import javax.ejb.Singleton;

@Singleton
@Lock(LockType.READ)
@Remote(Contador.class)
public class ContadorBean implements Contador{
	
	private int valor;

	@Override
	public void incrementa() {
		this.valor++;
	}

	@Override
	public int getValor() {
		return this.valor;
	}

}
