class NegociacaoController{

	constructor(){ // para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
		let $ = document.querySelector.bind(document); // Neste caso let $ = document.querySelector; como o querySelector é imutavel não daria para ser utiilizado por isso
		// alteramos para o atual, garantindo a associação com document

		this._inputData = $("#data");
		this._inputQuantidade = $("#quantidade");
		this._inputValor = $("#valor");

		this._listaNegociacoes = new Bind(new ListaNegociacoes(), new NegociacoesView($("#negociacoesView")), "adiciona", "esvazia"); 
			// ProxyFactory.create(new ListaNegociacoes(), ["adiciona", "esvazia"], model => this._negociacoesView.update(model));
		
		this._mensagem = new Bind(new Mensagem(), new MensagemView($("#mensagemView")), "texto"); 
			// ProxyFactory.create(new Mensagem(), ["texto"], (model) => this._mensagemView.update(model));
	}
	
	adiciona(event){
		event.preventDefault();
		
		this._listaNegociacoes.adiciona(this._criaNegociacao());
		this._mensagem.texto = "Negociação adicionada com sucesso!";
		this._limpaFormulario();
	}
	
	importaNegociacoes(){
		let xhr = new XMLHttpRequest();
		xhr.open("GET", "negociacoes/semana");
		
		xhr.onreadystatechange = () => {
			/*
			 * 0: requisição ainda não iniciada
			 * 
			 * 1: conexão com o servidor estabelecidad
			 * 
			 * 2: requisição recebida
			 * 
			 * 3: processando requisição
			 * 
			 * 4: requisição concluida e a resposta esta pronta
			 */
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					console.log("Obtendo as negociações do servidor.");
					console.log(JSON.parse(xhr.responseText));
					JSON.parse(xhr.responseText).map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor))
					.forEach(negociacao => this._listaNegociacoes.adiciona(negociacao));
					this._mensagem.texto = "Negociações encontradas com sucesso!"
				} else {
					console.log("Não foi possível obter as negociações do servidor.");
					console.log(xhr.responseText);
					this._mensagem.texto = "Não foi possível obter as negociações."
				}
			}
			
		};
		
		xhr.send();
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