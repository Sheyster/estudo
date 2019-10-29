"use strict";

System.register(["./HttpService", "./ConnectionFactory", "../dao/NegociacaoDao", "../models/Negociacao"], function (_export, _context) {
	"use strict";

	var HttpService, ConnectionFactory, NegociacaoDao, Negociacao, _createClass, NegociacaoService;

	function _classCallCheck(instance, Constructor) {
		if (!(instance instanceof Constructor)) {
			throw new TypeError("Cannot call a class as a function");
		}
	}

	return {
		setters: [function (_HttpService) {
			HttpService = _HttpService.HttpService;
		}, function (_ConnectionFactory) {
			ConnectionFactory = _ConnectionFactory.ConnectionFactory;
		}, function (_daoNegociacaoDao) {
			NegociacaoDao = _daoNegociacaoDao.NegociacaoDao;
		}, function (_modelsNegociacao) {
			Negociacao = _modelsNegociacao.Negociacao;
		}],
		execute: function () {
			_createClass = function () {
				function defineProperties(target, props) {
					for (var i = 0; i < props.length; i++) {
						var descriptor = props[i];
						descriptor.enumerable = descriptor.enumerable || false;
						descriptor.configurable = true;
						if ("value" in descriptor) descriptor.writable = true;
						Object.defineProperty(target, descriptor.key, descriptor);
					}
				}

				return function (Constructor, protoProps, staticProps) {
					if (protoProps) defineProperties(Constructor.prototype, protoProps);
					if (staticProps) defineProperties(Constructor, staticProps);
					return Constructor;
				};
			}();

			_export("NegociacaoService", NegociacaoService = function () {
				function NegociacaoService() {
					_classCallCheck(this, NegociacaoService);

					this._http = new HttpService();
				}

				_createClass(NegociacaoService, [{
					key: "obterNegociacoesDaSemana",
					value: function obterNegociacoesDaSemana() {
						return this._http.get("negociacoes/semana").then(function (negociacoes) {
							console.log(negociacoes);
							return negociacoes.map(function (objeto) {
								return new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor);
							});
						}).catch(function (err) {
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
				}, {
					key: "obterNegociacoesDaSemanaAnterior",
					value: function obterNegociacoesDaSemanaAnterior() {
						return this._http.get("negociacoes/anterior").then(function (negociacoes) {
							console.log(negociacoes);
							return negociacoes.map(function (objeto) {
								return new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor);
							});
						}).catch(function (err) {
							console.log(err);
							reject("Não foi possivel obter as negociações da semana anterior");
						});
					}
				}, {
					key: "obterNegociacoesDaSemanaRetrasada",
					value: function obterNegociacoesDaSemanaRetrasada() {
						return this._http.get("negociacoes/retrasada").then(function (negociacoes) {
							console.log(negociacoes);
							return negociacoes.map(function (objeto) {
								return new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor);
							});
						}).catch(function (err) {
							console.log(err);
							reject("Não foi possivel obter as negociações da semana retrasada");
						});
					}
				}, {
					key: "obterNegociacoes",
					value: function obterNegociacoes() {
						return Promise.all([this.obterNegociacoesDaSemana(), this.obterNegociacoesDaSemanaAnterior(), this.obterNegociacoesDaSemanaRetrasada()]).then(function (periodos) {
							var negociacoes = periodos.reduce(function (dados, periodo) {
								return dados.concat(periodo);
							}, []).map(function (dado) {
								return new Negociacao(new Date(dado.data), dado.quantidade, dado.valor);
							});
							return negociacoes;
						}).catch(function (err) {
							console.log(err);
							throw new Error(err);
						});
					}
				}, {
					key: "cadastrar",
					value: function cadastrar(negociacao) {

						return ConnectionFactory.getConnection().then(function (connection) {
							return new NegociacaoDao(connection);
						}).then(function (dao) {
							return dao.adiciona(negociacao);
						}).then(function () {
							return 'Negociação adicionada com sucesso';
						}).catch(function (err) {
							console.log(err);
							throw new Error('Não doi possível adicionar a negociação');
						});
					}
				}, {
					key: "lista",
					value: function lista() {
						return ConnectionFactory.getConnection().then(function (connection) {
							return new NegociacaoDao(connection);
						}).then(function (dao) {
							return dao.listaTodos();
						}).catch(function (err) {
							console.log(err);
							throw new Error('Nao foi possivel obter as negociacoes!');
						});
					}
				}, {
					key: "apaga",
					value: function apaga() {
						return ConnectionFactory.getConnection().then(function (connection) {
							return new NegociacaoDao(connection);
						}).then(function (dao) {
							return dao.apagarTodos();
						}).then(function (mensagem) {
							return 'Negociacoes apagadas com sucesso!';
						}).catch(function (err) {
							console.log(err);
							throw new Error('Nao foi possivel apagar as negociacoes!');
						});
					}
				}, {
					key: "importa",
					value: function importa(listaAtual) {
						return this.obterNegociacoes().then(function (negociacoes) {
							return negociacoes.filter(function (negociacao) {
								return !listaAtual.some(function (negociacaoExistente) {
									return JSON.stringify(negociacao) == JSON.stringify(negociacaoExistente);
								});
							});
						}).catch(function (err) {
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
				}]);

				return NegociacaoService;
			}());

			_export("NegociacaoService", NegociacaoService);
		}
	};
});
//# sourceMappingURL=NegociacaoService.js.map