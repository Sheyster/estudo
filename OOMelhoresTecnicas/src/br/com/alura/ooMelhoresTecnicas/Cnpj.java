package br.com.alura.ooMelhoresTecnicas;

import br.com.alura.ooMelhoresTecnicas.interfaces.Documento;

public class Cnpj implements Documento {

	private String valor;

	public boolean ehValido() {
		return primeiroDigitoVerificador() == primeiroDigitoCorreto()
				&& segundoDigitoVerificador() == segundoDigitoCorreto();
	}

	public String getValor() {
		return this.valor;
	}

	private int primeiroDigitoCorreto() {
		// Calcula o primeiro dígito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int primeiroDigitoVerificador() {
		// Extrai o primeiro dígito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	private int segundoDigitoCorreto() {
		// Calcula o segundo dígito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int segundoDigitoVerificador() {
		// Extrai o segundo dígito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	public void setValor(String novoValor) {
		this.valor = novoValor;
	}

	@Override
	public int hashCode() {
		return this.valor.hashCode(); // delegamos a geracao do hashCode da classe Cnpj para seu atributo String valor
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Cnpj)) {
			return false;
		}
		Cnpj outro = (Cnpj) obj;
		return this.valor.equals(outro.valor); // delegamos a comparação de dois Cnpj para seus atributos valor
	}

	@Override
	public String valor() {
		return this.valor;
	}

}