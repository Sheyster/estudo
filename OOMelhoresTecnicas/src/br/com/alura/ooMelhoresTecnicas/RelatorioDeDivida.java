package br.com.alura.ooMelhoresTecnicas;

import java.text.NumberFormat;
import java.util.Locale;

public class RelatorioDeDivida {

	private Divida divida;

	public RelatorioDeDivida(Divida divida) {
		this.divida = divida;
	}

	public void geraRelatorio(NumberFormat format) {
		System.out.println("Cnpj credor: " + divida.getDocumentoCredor());
		System.out.println("Credor: " + divida.getCredor());

		System.out.println("Valor pago da divida: " + format.format(divida.getTotal()));
		System.out.println("Valor pago: " + format.format(divida.getValorPago()));
	}

	public static void main(String[] args) {
		Cnpj cnpjCredor = new Cnpj();
		cnpjCredor.setValor("00.000.001/0001-01");

		Cnpj cnpjPagador = new Cnpj();
		cnpjPagador.setValor("00.000.002/0002-02");

		Divida divida = new Divida();
		divida.setCredor("Uma empresa");
		divida.setTotal(100);
		divida.setDocumentoCredor(cnpjCredor);

		Pagamento pagamento = new Pagamento();
		pagamento.setDocumentoPagador(cnpjPagador);
		pagamento.setPagador("Outra empresa");
		pagamento.setValor(20);
		divida.registra(pagamento);

		RelatorioDeDivida relatorioDeDivida = new RelatorioDeDivida(divida);
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		relatorioDeDivida.geraRelatorio(format);
	}
}
