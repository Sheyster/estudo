package br.com.alura.ooMelhoresTecnicas;

import java.util.HashMap;
import java.util.Map;

import br.com.alura.ooMelhoresTecnicas.exemplos.ArmazenadorDeDividas;
import br.com.alura.ooMelhoresTecnicas.interfaces.Documento;

public class BancoDeDados implements ArmazenadorDeDividas {

	private final Map<Documento, Divida> dividasNoBanco = new HashMap<Documento, Divida>();

	public BancoDeDados(String endereco, String usuario, String senha) {
		System.out.println("Conectando!");
	}

	public void salva(Divida divida) {
		dividasNoBanco.put(divida.getDocumentoCredor(), divida);
	}

	public Divida carrega(Documento documento) {
		return dividasNoBanco.get(documento);
	}

	public void desconecta() {
		System.out.println("Desconecta!");
	}
}
