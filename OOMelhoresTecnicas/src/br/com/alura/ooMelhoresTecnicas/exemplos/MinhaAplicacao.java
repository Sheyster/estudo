package br.com.alura.ooMelhoresTecnicas.exemplos;

import br.com.alura.ooMelhoresTecnicas.BalancoEmpresa;
import br.com.alura.ooMelhoresTecnicas.Cnpj;
import br.com.alura.ooMelhoresTecnicas.Divida;
import br.com.alura.ooMelhoresTecnicas.Pagamento;
import br.com.alura.ooMelhoresTecnicas.interfaces.Documento;

public class MinhaAplicacao {

	public static void main(String[] args) {
		// BancoDeDados bd = new BancoDeDados("localhost", "usuario", "123");
		Arquivo bd = new Arquivo();
		BalancoEmpresa balanco = new BalancoEmpresa(bd);
		registraDividas(balanco);
		realizaPagamentos(balanco);
//		bd.desconecta();
	}

	private static void registraDividas(BalancoEmpresa balanco) {
		Divida divida1 = new Divida();
		Divida divida2 = new Divida();

		divida1.setCredor("Uma empresa");
		divida1.setDocumentoCredor(new Cnpj("00.000.001/0001-01"));
		divida1.setTotal(1000);

		divida2.setCredor("Meu vizinho");
		divida2.setDocumentoCredor(new Cnpj("00.000.002/0002-02"));
		divida2.setTotal(100);

		balanco.registraDivida(divida1);
		balanco.registraDivida(divida2);
	}

	private static void realizaPagamentos(BalancoEmpresa balanco) {
		Pagamento pagamento1 = new Pagamento();
		Pagamento pagamento2 = new Pagamento();

		Documento documento1 = new Cnpj("00.000.003/0003-03");
		Documento documento2 = new Cnpj("00.000.004/0004-04");

		pagamento1.setDocumentoPagador(documento1);
		pagamento1.setPagador("Outra empresa pagamento");
		pagamento1.setValor(200);

		pagamento2.setDocumentoPagador(documento2);
		pagamento2.setPagador("Outra empresa vizinho pagamento");
		pagamento2.setValor(20);

		balanco.pagaDivida(documento1, pagamento1);
		balanco.pagaDivida(documento2, pagamento2);
	}
}
