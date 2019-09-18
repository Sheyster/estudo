class NegociacaoController{

	constructor(){ // para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
		let $ = document.querySelector.bind(document); // Neste caso let $ = document.querySelector; como o querySelector é imutavel não daria para ser utiilizado por isso
		// alteramos para o atual, garantindo a associação com document

		this._inputData = $("#data");
		this._inputQuantidade = $("#quantidade");
		this._inputValor = $("#valor");

		this._negociacoesView = new NegociacoesView($("#negociacoesView"));

		this._listaNegociacoes = new Bind(new ListaNegociacoes(), this._negociacoesView, ["adiciona", "esvazia"]); 
			// ProxyFactory.create(new ListaNegociacoes(), ["adiciona", "esvazia"], model => this._negociacoesView.update(model));
		
		this._mensagemView = new MensagemView($("#mensagemView"));

		this._mensagem = new Bind(new Mensagem(), this._mensagemView, ["texto"]); 
			// ProxyFactory.create(new Mensagem(), ["texto"], (model) => this._mensagemView.update(model));
	}
	
	adiciona(event){
		event.preventDefault();
		
		this._listaNegociacoes.adiciona(this._criaNegociacao());
		this._mensagem.texto = "Negociação adicionada com sucesso!";
		this._limpaFormulario();
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
}