package br.com.k19.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.k19.sessionbeans.Carrinho;

public class TesteCicloDeVidaSFSB {

	public static void main(String[] args) throws Exception {
		Properties props = new Properties();
		props.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
		props.put(Context.PROVIDER_URL, "remote://127.0.0.1:4447");
		props.put(Context.SECURITY_PRINCIPAL, "k19");
		props.put(Context.SECURITY_CREDENTIALS, "1234");
		
		InitialContext ic = new InitialContext(props);
		
		Carrinho[] carrinhos = new Carrinho[6];
		
		for (int i = 0; i < carrinhos.length; i++) {
			carrinhos[i] = (Carrinho) ic.lookup("carrinhoWeb/CarrinhoBean!br.com.k19.sessionbeans.Carrinho");
			carrinhos[i].adiciona("Chaveiro - k19");
			carrinhos[i].adiciona("Caneta - k19");
			Thread.sleep(1000);
		}
		
		carrinhos[0].adiciona("Borracha - k19");
		
		Thread.sleep(5000);
		
		carrinhos[0].finalizaCompra();
	}
}
