package br.com.k19.sessionbeans;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

@Singleton
//@Startup
public class ChatBean {

	private Set<String> salas = new HashSet<>();
	
	public void criaSala(String sala){
		this.salas.add(sala);
	}
	
	public List<String> listaSalas(){
		return new ArrayList<>(this.salas);
	}
	
	@PostConstruct
	public void postConstruct(){
		System.out.println("Criando o chatbean.");
	}
	
	@PreDestroy
	public void preDestroy(){
		System.out.println("Destruindo o chatbean.");
	}
}
