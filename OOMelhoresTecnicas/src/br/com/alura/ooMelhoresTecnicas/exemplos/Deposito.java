package br.com.alura.ooMelhoresTecnicas.exemplos;

public class Deposito {
	private String numeroEnvelope;
	private DadosDeMovimentacao movimentacao = new DadosDeMovimentacao();

	public double getEncargos() {
		throw new RuntimeException("Depositos não sofrem encargos");
	}

	public String getNumeroEnvelope() {
		return numeroEnvelope;
	}

	public void setNumeroEnvelope(String numeroEnvelope) {
		this.numeroEnvelope = numeroEnvelope;
	}

}
