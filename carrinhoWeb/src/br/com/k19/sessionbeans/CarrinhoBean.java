/**
 * 
 */
package br.com.k19.sessionbeans;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Stateful;

/**
 * @author eltonf
 *
 */
@Stateful
public class CarrinhoBean {

	private Set<String> produtos = new HashSet<String>();
	
	public void adiciona(String produto){
		this.produtos.add(produto);
	}
	
	public void remove(String produto){
		this.produtos.remove(produto);
	}

	/**
	 * @return the produtos
	 */
	public Set<String> getProdutos() {
		return produtos;
	}
	
}
