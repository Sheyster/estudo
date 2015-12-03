package br.com.alura.exceptions;

public class ValorInvalidoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5952496540611574327L;

	public ValorInvalidoException(double valor) {
		super("Valor invalido: " + valor);
	}

	public ValorInvalidoException(String message) {
		super(message);
	}
}
