package br.com.alura.ooMelhoresTecnicas.teste;

import br.com.alura.ooMelhoresTecnicas.Pagamento;
import br.com.alura.ooMelhoresTecnicas.Pagamentos;

public class TestaPagamento {

	public static void main(String[] args) {
		Pagamentos pagamentos = new Pagamentos();
		Pagamento pagamento1 = new Pagamento();
		Pagamento pagamento2 = new Pagamento();
		pagamento1.setValor(105);
		pagamento2.setValor(25);

		pagamentos.registra(pagamento1);
		pagamentos.registra(pagamento2);

		System.out.println("Valor total pago: " + pagamentos.getValorPago());

		Iterable<Pagamento> lista = new Pagamentos();
		for (Pagamento pagamento : pagamentos) {
			System.out.println(pagamento.getValor());
		}
//
//		Pagamentos pagamentos2 = new Pagamentos();
//		ArrayList<Pagamento> colecaoDePagamentos = new ArrayList<Pagamento>();
//		colecaoDePagamentos.add(pagamento1);
//		colecaoDePagamentos.add(pagamento2);
//		pagamentos2.addAll(colecaoDePagamentos);
//
//		System.out.println("Valor total pago: " + pagamentos2.getValorPago());
	}

}
