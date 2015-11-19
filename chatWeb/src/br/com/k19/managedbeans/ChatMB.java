package br.com.k19.managedbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import br.com.k19.sessionbeans.ChatBean;

@ManagedBean
public class ChatMB {

	@EJB
	private ChatBean chatBean;
	
	private String sala;
	
	public void adicionaSala(){
		this.chatBean.criaSala(this.sala);
	}
	
	public List<String> getSalas(){
		return this.chatBean.listaSalas();
	}

	/**
	 * @return the sala
	 */
	public String getSala() {
		return sala;
	}

	/**
	 * @param sala the sala to set
	 */
	public void setSala(String sala) {
		this.sala = sala;
	}

}
