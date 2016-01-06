/**
 * 
 */
package br.com.alura;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eltonf
 *
 */
public class Banco {

	private final List<Conta> contas = new ArrayList<>();
	private final Map<String, Conta> mapContas = new HashMap<>();

	void adiciona(Conta c) {
		this.contas.add(c);
		this.mapContas.put(c.getNome(), c);
	}

	Conta getConta(int x) {
		return this.contas.get(x);
	}

	int getQuantidadeContas() {
		return this.contas.size();
	}

	Conta buscaPorNome(String nome) {
		return this.mapContas.get(nome);
	}
}
