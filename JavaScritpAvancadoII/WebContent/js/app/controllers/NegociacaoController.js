class NegociacaoController{

	constructor(){ // para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
		let $ = document.querySelector.bind(document); // Neste caso let $ = document.querySelector; como o querySelector é imutavel não daria para ser utiilizado por isso
		// alteramos para o atual, garantindo a associação com document

		this._inputData = $("#data");
		this._inputQuantidade = $("#quantidade");
		this._inputValor = $("#valor");

		// ??????
		// this._listaNegociacoes = new ListaNegociacoes(model => this._negociacoesView.update(model));
		let self = this;
		this._listaNegociacoes = new Proxy(new ListaNegociacoes(), {
    		
    		get(target, prop, receiver) {
    			if(['adiciona', 'esvazia'].includes(prop) && typeof(target[prop]) == typeof(Function)){
    				return function() {
    					console.log(`interceptando ${prop}`);
    					Reflect.apply(target[prop], target, arguments);
    					self._negociacoesView.update(target);
    				}
    			}
    			
    			return Reflect.get(target, prop, receiver);
    			/*
				 * console.log(`Valor antigo: ${target[prop]} - Novo valor: ${value}`); return Reflect.set(target, prop, value, receiver);
				 */
    		}
    	});
		
		this._negociacoesView = new NegociacoesView($("#negociacoesView"));
		this._negociacoesView.update(this._listaNegociacoes);
		// Object.freeze(this); // Essa funcao faz com não consigamos alterar o valor de um atributo de uma classe, similar ao private do Java
		
		this._mensagem = new Mensagem();
		this._mensagemView = new MensagemView($("#mensagemView"));
		this._mensagemView.update(this._mensagem);
	}
	
	adiciona(event){
		event.preventDefault();
		
				// para um arrow function que contenha somente uma linha de decisão podemos deixar ela menos verbosa da sequinte forma
		let data2 = new Date(...this._inputData.value.split("-").map((item, indice) => item - indice % 2));
		this._listaNegociacoes.adiciona(this._criaNegociacao());
		
		this._mensagem.texto = "Negociação adicionada com sucesso!";
		this._mensagemView.update(this._mensagem);
		
		this._limpaFormulario();
	}
	
	apaga() {
		this._listaNegociacoes.esvazia();
		
		this._mensagem.texto = "Negociações apagadas com sucesso!";
		this._mensagemView.update(this._mensagem);
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