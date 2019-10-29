import { HttpService } from "./HttpService";
import { ConnectionFactory } from "./ConnectionFactory";
import { NegociacaoDao } from "../dao/NegociacaoDao";
import { Negociacao } from "../models/Negociacao";

export class NegociacaoService {

	constructor() {
		this._http = new HttpService();
	}

	obterNegociacoesDaSemana() {
		return this._http
			.get("negociacoes/semana")
			.then(negociacoes => {
				console.log(negociacoes);
				return negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor));
			})
			.catch(err => {
				console.log(err);
				reject("Não foi possivel obter as negociações da semana");
			});
		/*
		 * return new Promise((resolve, reject) => {
		 * 
		 * let xhr = new XMLHttpRequest(); xhr.open("GET", "negociacoes/semana");
		 * 
		 * xhr.onreadystatechange = () => {
		 * 
		 * 0: requisição ainda não iniciada
		 * 
		 * 1: conexão com o servidor estabelecidad
		 * 
		 * 2: requisição recebida
		 * 
		 * 3: processando requisição
		 * 
		 * 4: requisição concluida e a resposta esta pronta
		 * 
		 * if(xhr.readyState == 4){ if(xhr.status == 200){ console.log("Obtendo as negociações do servidor."); console.log(JSON.parse(xhr.responseText));
		 * 
		 * resolve(JSON.parse(xhr.responseText).map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor))); } else { console.log("Não foi possível obter
		 * as negociações do servidor."); console.log(xhr.responseText); reject("Não foi possível obter as negociações.") } } };
		 * 
		 * xhr.send(); });
		 */
	}

	obterNegociacoesDaSemanaAnterior() {
		return this._http
			.get("negociacoes/anterior")
			.then(negociacoes => {
				console.log(negociacoes);
				return negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor));
			})
			.catch(err => {
				console.log(err);
				reject("Não foi possivel obter as negociações da semana anterior");
			});
	}

	obterNegociacoesDaSemanaRetrasada() {
		return this._http
			.get("negociacoes/retrasada")
			.then(negociacoes => {
				console.log(negociacoes)
				return negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor));
			})
			.catch(err => {
				console.log(err);
				reject("Não foi possivel obter as negociações da semana retrasada");
			});
	}

	obterNegociacoes() {
		return Promise.all([
			this.obterNegociacoesDaSemana(),
			this.obterNegociacoesDaSemanaAnterior(),
			this.obterNegociacoesDaSemanaRetrasada()
		]).then(periodos => {
			let negociacoes = periodos
				.reduce((dados, periodo) => dados.concat(periodo), [])
				.map(dado => new Negociacao(new Date(dado.data), dado.quantidade, dado.valor));
			return negociacoes;
		}).catch(err => {
			console.log(err);
			throw new Error(err);
		});
	}

	cadastrar(negociacao) {

		return ConnectionFactory.getConnection()
			.then(connection => new NegociacaoDao(connection))
			.then(dao => dao.adiciona(negociacao))
			.then(() => 'Negociação adicionada com sucesso')
			.catch(err => {
				console.log(err);
				throw new Error('Não doi possível adicionar a negociação')
			});
	}

	lista() {
		return ConnectionFactory.getConnection()
			.then(connection => new NegociacaoDao(connection))
			.then(dao => dao.listaTodos())
			.catch(err => {
				console.log(err);
				throw new Error('Nao foi possivel obter as negociacoes!');
			});
	}

	apaga() {
		return ConnectionFactory.getConnection()
			.then(connection => new NegociacaoDao(connection))
			.then(dao => dao.apagarTodos())
			.then(mensagem => 'Negociacoes apagadas com sucesso!')
			.catch(err => {
				console.log(err);
				throw new Error('Nao foi possivel apagar as negociacoes!');
			});
	}

	importa(listaAtual) {
		return this.obterNegociacoes()
			.then(negociacoes =>
				negociacoes.filter(negociacao =>
					!listaAtual.some(negociacaoExistente =>
						JSON.stringify(negociacao) == JSON.stringify(negociacaoExistente)))
			)
			.catch(err => {
				console.log(err);
				throw new Error('Não foi possível buscar as negociações para importar');
			});

		// Promise.all([this._service.obterNegociacoesDaSemana(), this._service.obterNegociacoesDaSemanaAnterior(), service.obterNegociacoesDaSemanaRetrasada()])
		// 	.then(negociacoes =>
		// 		negociacoes.filter(negociacao =>
		// 			!this._listaNegociacoes.negociacoes.some(negociacaoExistente =>
		// 				JSON.stringify(negociacao) == JSON.stringify(negociacaoExistente)))
		// 	)
		// 	.then(negociacoes => negociacoes.forEach(negociacao => {
		// 		this._listaNegociacoes.adiciona(negociacao);
		// 		this._mensagem.texto = 'Negociação do periodo importada,';
		// 	}))
		// 	.catch(err => this._mensagem.texto = err);
	}
}