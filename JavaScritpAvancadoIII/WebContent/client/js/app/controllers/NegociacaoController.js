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
		this._init();
	}

	_init() {
		new NegociacaoService()
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
		}, 900000);
	}

	adiciona(event) {
		event.preventDefault();

		let negociacao = this._criaNegociacao();
		new NegociacaoService()
			.cadastrar(negociacao)
			.then(mensagem => {
				this._listaNegociacoes.adiciona(negociacao);
				this._mensagem.texto = mensagem;
			}).catch(err => {
				this._mensagem.texto = err;
			});
	}

	importaNegociacoes() {
		let service = new NegociacaoService();

		// Para resolver um possivel problema de sincronidade
		Promise.all([service.obterNegociacoesDaSemana(), service.obterNegociacoesDaSemanaAnterior(), service.obterNegociacoesDaSemanaRetrasada()])
			// Para resolver o problema de duplicidade na importação dos dados
			.then(negociacoes =>
				negociacoes.filter(negociacao =>
					!this._listaNegociacoes.negociacoes.some(negociacaoExistente =>
						JSON.stringify(negociacao) == JSON.stringify(negociacaoExistente)))
			)
			.then(negociacoes => negociacoes.forEach(negociacao => {
				this._listaNegociacoes.adiciona(negociacao);
				this._mensagem.texto = 'Negociação do periodo importada,';
			}))

			// .then(negociacoes => {
			// 	negociacoes
			// 		.reduce((arrayAchatado, array) => arrayAchatado.concat(array), [])
			// 		.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
			// 	this._mensagem.texto = "Negociações importadas com sucesso!";
			// })
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
		ConnectionFactory.getConnection()
			.then(connection => new NegociacaoDao(connection))
			.then(dao => dao.apagarTodos())
			.then(mensagem => {
				this._mensagem.texto = mensagem;
				this._listaNegociacoes.esvazia();
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