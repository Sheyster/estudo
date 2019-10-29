import { ListaNegociacoes } from "../models/ListaNegociacoes";
import { Mensagem } from "../models/Mensagem";
import { Negociacao } from "../models/Negociacao";
import { NegociacoesView } from "../views/NegociacoesView";
import { MensagemView } from "../views/MensagemView";
import { NegociacaoService } from "../services/NegociacaoService";
import { DateHelper } from "../helpers/DateHelper";
import { Bind } from "../helpers/Bind";

class NegociacaoController {

	constructor() { // para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
		let $ = document.querySelector.bind(document); // Neste caso let $ = document.querySelector; como o querySelector é imutavel não daria para ser utiilizado por isso
		// alteramos para o atual, garantindo a associação com document

		this._inputData = $("#data");
		this._inputQuantidade = $("#quantidade");
		this._inputValor = $("#valor");

		this._listaNegociacoes = new Bind(new ListaNegociacoes(), new NegociacoesView($("#negociacoesView")), "adiciona", "esvazia", "ordena", "inverteOrdem");
		// ProxyFactory.create(new ListaNegociacoes(), ["adiciona", "esvazia"], model => this._negociacoesView.update(model));

		this._mensagem = new Bind(new Mensagem(), new MensagemView($("#mensagemView")), "texto");
		// ProxyFactory.create(new Mensagem(), ["texto"], (model) => this._mensagemView.update(model));

		this._ordemAtual = '';
		this._service = new NegociacaoService();
		this._init();
	}

	_init() {
		this._service
			.lista()
			.then(negociacoes =>
				negociacoes.forEach(negociacao =>
					this._listaNegociacoes.adiciona(negociacao)))
			.catch(err => {
				console.log(err);
				this._mensagem.texto = err;
			});

		// Outra forma de fazer a mesma coisa abaixo.
		// ConnectionFactory.getConnection()
		// 	.then(connection => new NegociacaoDao(connection))
		// 	.then(dao => dao.listaTodos())
		// 	.then(negociacoes => negociacoes
		// 		.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao)))
		// 	.catch(err => {
		// 		console.log(err);
		// 		this._mensagem.texto = err;
		// 	});

		// ConnectionFactory.getConnection().then(connection => {
		// 	new NegociacaoDao(connection).listaTodos().then(negociacoes => {
		// 		this._listaNegociacoes.adiciona(negociacoes);
		// 	});
		// });

		setInterval(() => {
			this.importaNegociacoes();
		}, 9000);
	}

	adiciona(event) {
		event.preventDefault();

		let negociacao = this._criaNegociacao();
		this._service
			.cadastrar(negociacao)
			.then(mensagem => {
				this._listaNegociacoes.adiciona(negociacao);
				this._mensagem.texto = mensagem;
			}).catch(err => {
				this._mensagem.texto = err;
			});
	}

	importaNegociacoes() {
		this._service
			.importa(this._listaNegociacoes.negociacoes)
			.then(negociacoes => negociacoes.forEach(negociacao => {
				this._listaNegociacoes.adiciona(negociacao);
				this._mensagem.texto = 'Negociação do periodo importada,';
			}))
			.catch(err => this._mensagem.texto = err);

		/*
		 * let promise = service.obterNegociacoesDaSemana(); promise.then(negociacoes => { negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao))
		 * this._mensagem.texto = "Negociações importadas com sucesso!"; }) .catch(err => this._mensagem.texto = err);
		 */

		/*
		 * service.obterNegociacoesDaSemana((err, negociacoes) => { if(err) { this._mensagem.texto = err; return; }
		 * 
		 * negociacoes.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao)); this._mensagem.texto = "Negociações importadas com sucesso!"; });
		 */
	}

	apaga() {
		this._service
			.apaga()
			.then(mensagem => {
				this._mensagem.texto = mensagem;
				this._listaNegociacoes.esvazia();
			})
			.catch(err => {
				this._mensagem.texto = err;
				console.log(err);
			});
	}

	_criaNegociacao() {
		return new Negociacao(DateHelper.textoParaData(this._inputData.value), parseInt(this._inputQuantidade.value), parseFloat(this._inputValor.value));
	}
	_limpaFormulario() {
		this._inputData.value = "";
		this._inputQuantidade.value = 1;
		this._inputValor.value = 0.0;

		this._inputData.focus();
	}

	ordena(coluna) {
		// ainda vamos implementar o método!
		console.log("Testando ordenação" + coluna);
		if (this._ordemAtual == coluna) {
			// inverte a ordem da lista!
			this._listaNegociacoes.inverteOrdem();
		} else {
			this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
		}
		this._ordemAtual = coluna;
	}
}

let negociacaoController = new NegociacaoController();

export function currentInstance() {
	return negociacaoController;
}