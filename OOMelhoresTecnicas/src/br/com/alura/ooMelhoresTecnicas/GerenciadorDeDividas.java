package br.com.alura.ooMelhoresTecnicas;

public class GerenciadorDeDividas {

	public void efetuaPagamento(Divida divida, String nomePagador, String cnpjPagador, double valor) {
		Pagamento pagamento = new Pagamento();
		pagamento.setCnpjPagador(cnpjPagador);
		pagamento.setPagador(nomePagador);
		pagamento.setValor(valor);
		divida.getPagamentos().registra(pagamento);
		divida.getPagamentos().add(pagamento);
	}
}
