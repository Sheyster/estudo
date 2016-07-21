/**
 * 
 */
package br.com.alura.designPatterns.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.alura.designPatterns.observer.AcaoAposGerarNota;

/**
 * @author eltonf
 *
 */
public class NotaFiscalBuilder {

	private String razaoSocial;
	private String CNPJ;
	private double valorBruto;
	private double impostos;
	private Calendar data;
	private String observacao;
	private List<ItemDaNota> todosItens = new ArrayList<>();
	private List<AcaoAposGerarNota> todasAcoesASeremExecutadas;

	public NotaFiscalBuilder() {
		this.data = Calendar.getInstance();
		this.todasAcoesASeremExecutadas = new ArrayList<AcaoAposGerarNota>();
	}

	public NotaFiscalBuilder(List<AcaoAposGerarNota> listaNovasAcoes) {
		this.todasAcoesASeremExecutadas = listaNovasAcoes;
	}

	public void adicionaAcao(AcaoAposGerarNota novaAcao) {
		this.todasAcoesASeremExecutadas.add(novaAcao);
	}

	public NotaFiscal constroi() {
		NotaFiscal notaFiscal = new NotaFiscal(razaoSocial, CNPJ, valorBruto, impostos, data, observacao, todosItens);

		for (AcaoAposGerarNota gerarNota : todasAcoesASeremExecutadas) {
			gerarNota.executa(notaFiscal);
		}
		return notaFiscal;
	}

	public NotaFiscalBuilder paraEmpresa(String razaoSocial) {
		this.razaoSocial = razaoSocial;
		return this;
	}

	public NotaFiscalBuilder comCnpj(String CNPJ) {
		this.CNPJ = CNPJ;
		return this;
	}

	public NotaFiscalBuilder com(ItemDaNota item) {
		todosItens.add(item);
		valorBruto += item.getValor();
		impostos += item.getValor() * 0.05;
		return this;
	}

	public NotaFiscalBuilder comObservacao(String observacao) {
		this.observacao = observacao;
		return this;
	}

	public NotaFiscalBuilder naData(Calendar data) {
		this.data = data;
		return this;
	}

	// public NotaFiscalBuilder naDataAtual() {
	// this.data = Calendar.getInstance();
	// return this;
	// }
}
