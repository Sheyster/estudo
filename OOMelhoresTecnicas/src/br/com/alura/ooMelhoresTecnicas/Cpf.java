package br.com.alura.ooMelhoresTecnicas;

import br.com.alura.ooMelhoresTecnicas.interfaces.Documento;

public class Cpf implements Documento {

	private final String valor;

	public Cpf(String valor) {
		this.valor = valor;
	}

	public String valor() {
		return valor;
	}

	@Override
	public String toString() {
		return valor;
	}

	@Override
	public int hashCode() {
		return this.valor.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cpf)) {
			return false;
		}
		Cpf outro = (Cpf) obj;
		return this.valor.equals(outro.valor);
	}

	public boolean ehValido() {
		return primeiroDigitoVerificadorCorreto() && segundoDigitoVerificadorCorreto();
	}

	private boolean segundoDigitoVerificadorCorreto() {
		return false;
	}

	private boolean primeiroDigitoVerificadorCorreto() {
		return false;
	}
}