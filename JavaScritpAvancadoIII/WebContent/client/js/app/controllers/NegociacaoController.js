"use strict";

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

var NegociacaoController = function () {
	function NegociacaoController() {
		_classCallCheck(this, NegociacaoController);

		// para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
		var $ = document.querySelector.bind(document); // Neste caso let $ = document.querySelector; como o querySelector é imutavel não daria para ser utiilizado por isso
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

	_createClass(NegociacaoController, [{
		key: "_init",
		value: function _init() {
			var _this = this;

			this._service.lista().then(function (negociacoes) {
				return negociacoes.forEach(function (negociacao) {
					return _this._listaNegociacoes.adiciona(negociacao);
				});
			}).catch(function (err) {
				console.log(err);
				_this._mensagem.texto = err;
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

			setInterval(function () {
				_this.importaNegociacoes();
			}, 9000);
		}
	}, {
		key: "adiciona",
		value: function adiciona(event) {
			var _this2 = this;

			event.preventDefault();

			var negociacao = this._criaNegociacao();
			this._service.cadastrar(negociacao).then(function (mensagem) {
				_this2._listaNegociacoes.adiciona(negociacao);
				_this2._mensagem.texto = mensagem;
			}).catch(function (err) {
				_this2._mensagem.texto = err;
			});
		}
	}, {
		key: "importaNegociacoes",
		value: function importaNegociacoes() {
			var _this3 = this;

			this._service.importa(this._listaNegociacoes.negociacoes).then(function (negociacoes) {
				return negociacoes.forEach(function (negociacao) {
					_this3._listaNegociacoes.adiciona(negociacao);
					_this3._mensagem.texto = 'Negociação do periodo importada,';
				});
			}).catch(function (err) {
				return _this3._mensagem.texto = err;
			});

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
	}, {
		key: "apaga",
		value: function apaga() {
			var _this4 = this;

			this._service.apaga().then(function (mensagem) {
				_this4._mensagem.texto = mensagem;
				_this4._listaNegociacoes.esvazia();
			}).catch(function (err) {
				_this4._mensagem.texto = err;
				console.log(err);
			});
		}
	}, {
		key: "_criaNegociacao",
		value: function _criaNegociacao() {
			return new Negociacao(DateHelper.textoParaData(this._inputData.value), parseInt(this._inputQuantidade.value), parseFloat(this._inputValor.value));
		}
	}, {
		key: "_limpaFormulario",
		value: function _limpaFormulario() {
			this._inputData.value = "";
			this._inputQuantidade.value = 1;
			this._inputValor.value = 0.0;

			this._inputData.focus();
		}
	}, {
		key: "ordena",
		value: function ordena(coluna) {
			// ainda vamos implementar o método!
			console.log("Testando ordenação" + coluna);
			if (this._ordemAtual == coluna) {
				// inverte a ordem da lista!
				this._listaNegociacoes.inverteOrdem();
			} else {
				this._listaNegociacoes.ordena(function (a, b) {
					return a[coluna] - b[coluna];
				});
			}
			this._ordemAtual = coluna;
		}
	}]);

	return NegociacaoController;
}();
//# sourceMappingURL=NegociacaoController.js.map