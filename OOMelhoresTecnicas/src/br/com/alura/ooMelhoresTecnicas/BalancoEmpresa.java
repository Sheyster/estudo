package br.com.alura.ooMelhoresTecnicas;

import java.util.HashMap;

import br.com.alura.ooMelhoresTecnicas.interfaces.Documento;

public class BalancoEmpresa {
	private HashMap<Documento, Divida> dividasPJ = new HashMap<Documento, Divida>();

	public void registraDivida(Divida divida) {
		dividasPJ.put(divida.getDocumentoCredor(), divida);
	}

	public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
		Divida divida = dividasPJ.get(documentoCredor);
		if (divida != null) {
			divida.registra(pagamento);
		}
	}

}