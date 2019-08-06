package br.com.alura.ooMelhoresTecnicas;

public class Divida {
	private double total;
	private String credor;
	private Cnpj cnpjCredor = new Cnpj();

	private Pagamentos pagamentos = new Pagamentos();

	public double getTotal() {
		return this.total;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}

	public String getCredor() {
		return this.credor;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getCnpjCredor() {
		return cnpjCredor.getValor();
	}

	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}

	public double getValorPago() {
		return pagamentos.getValorPago();
	}

	public void setCnpjCredor(Cnpj cnpjCredor) {
		this.cnpjCredor = cnpjCredor;
	}

}