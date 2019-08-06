package br.com.alura.ooMelhoresTecnicas.exemplos;

public class Pagamento {
	private String favorecido;
	private String formaDePagamento;
	private DadosDeMovimentacao dados = new DadosDeMovimentacao();

	public String getFavorecido() {
		return favorecido;
	}

	public void setFavorecido(String favorecido) {
		this.favorecido = favorecido;
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public double getEncargos() {
		return dados.getEncargos();
	}
}
