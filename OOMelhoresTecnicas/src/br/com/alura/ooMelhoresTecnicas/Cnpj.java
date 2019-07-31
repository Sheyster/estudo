package br.com.alura.ooMelhoresTecnicas;

public class Cnpj {

	private String valor;

	public boolean ehValido() {
		return primeiroDigitoVerificador() == primeiroDigitoCorreto()
				&& segundoDigitoVerificador() == segundoDigitoCorreto();
	}

	public String getValor() {
		return this.valor;
	}

	private int primeiroDigitoCorreto() {
		// Calcula o primeiro d�gito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int primeiroDigitoVerificador() {
		// Extrai o primeiro d�gito verificador do CNPJ armazenado
		// no atributo valor
		return 0;
	}

	private int segundoDigitoCorreto() {
		// Calcula o segundo d�gito verificador correto para
		// o CNPJ armazenado no atributo valor
		return 0;
	}

	private int segundoDigitoVerificador() {
		// Extrai o segundo d�gito verificador do CNPJ armazenado
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
		return this.valor.equals(outro.valor); // delegamos a compara��o de dois Cnpj para seus atributos valor
	}

}