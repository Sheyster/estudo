package br.com.alura.ooMelhoresTecnicas.exemplos;

import br.com.alura.ooMelhoresTecnicas.Divida;
import br.com.alura.ooMelhoresTecnicas.interfaces.Documento;

public interface ArmazenadorDeDividas {

	void salva(Divida divida);

	Divida carrega(Documento documento);
}
