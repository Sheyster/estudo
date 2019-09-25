class NegociacaoController{

	constructor(){ // para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
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
	}
	
	adiciona(event){
		event.preventDefault();
		
		this._listaNegociacoes.adiciona(this._criaNegociacao());
		this._mensagem.texto = "Negociação adicionada com sucesso!";
		this._limpaFormulario();
	}
	
	importaNegociacoes(){
		let service = new NegociacaoService();
		
		// Para resolver um possivel problema de sincronidade
		Promise.all([service.obterNegociacoesDaSemana(), service.obterNegociacoesDaSemanaAnterior(), service.obterNegociacoesDaSemanaRetrasada()])
		.then(negociacoes => {
			negociacoes
			.reduce((arrayAchatado, array) => arrayAchatado.concat(array), [])
			.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
			this._mensagem.texto = "Negociações importadas com sucesso!";
		})
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
		this._listaNegociacoes.esvazia();
		this._mensagem.texto = "Negociações apagadas com sucesso!";
	}
	
	_criaNegociacao(){
		return new Negociacao(DateHelper.textoParaData(this._inputData.value), this._inputQuantidade.value, this._inputValor.value);
	}
	_limpaFormulario(){
		this._inputData.value = "";
		this._inputQuantidade.value = 1;
		this._inputValor.value = 0.0;
		
		this._inputData.focus();
	}
	
	ordena(coluna) {
	    // ainda vamos implementar o método!
		console.log("Testando ordenação" + coluna);
		if(this._ordemAtual == coluna) {
            // inverte a ordem da lista!
			this._listaNegociacoes.inverteOrdem();
        } else {
            this._listaNegociacoes.ordena((a, b) => a[coluna] - b[coluna]);
        }
        this._ordemAtual = coluna;
	}
}