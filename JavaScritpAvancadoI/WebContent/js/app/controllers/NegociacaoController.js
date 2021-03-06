class NegociacaoController{

	constructor(){ // para garantir que vamos buscar o DOM somente uma vez e não sempre que o método for chamado
		let $ = document.querySelector.bind(document); // Neste caso let $ = document.querySelector; como o querySelector é imutavel não daria para ser utiilizado por isso
		// alteramos para o atual, garantindo a associação com document

		this._inputData = $("#data");
		this._inputQuantidade = $("#quantidade");
		this._inputValor = $("#valor");
		this._listaNegociacoes = new ListaNegociacoes();
		this._negociacoesView = new NegociacoesView($("#negociacoesView"));

		this._negociacoesView.update(this._listaNegociacoes);
		// Object.freeze(this); // Essa funcao faz com não consigamos alterar o valor de um atributo de uma classe, similar ao private do Java
		
		this._mensagem = new Mensagem();
		this._mensagemView = new MensagemView($("#mensagemView"));
		this._mensagemView.update(this._mensagem);
	}
	
	adiciona(event){
		event.preventDefault();
		/*
		 * let negociacao = new Negociacao( this._inputData.value, this._inputQuantidade.value, this._inputValor.value );
		 */
		
		// let data = new Date(this.inputData.value.split("-")); // essa é uma forma de gerar um array para ser gerado uma data ao inves de deixar como string
		
		// let data = new Date(this.inputData.value.replace(/-/g, ',')); // essa é uma outra forma de converter a data e passar o - para ,
		
		// Esse código abaixo é para mostrar como podemos pegar um item no meio de um array e manipula-lo, existem formar mais faceis, mas isso é para aprendizado
// let data = new Date(...
// this._inputData.value.split("-").map((item, indice) => { // podemos remover a expressão "function(item, indice)" por "(item, indice) => " isso para o ES6 2015
// // if(indice == 1){
// // return item -1;
// // }
// // return item;
// // outra forma de fazer o mesmo código acima
// return item - indice % 2;
// })
// );
		
				// para um arrow function que contenha somente uma linha de decisão podemos deixar ela menos verbosa da sequinte forma
		let data2 = new Date(...this._inputData.value.split("-").map((item, indice) => item - indice % 2));
		this._listaNegociacoes.adiciona(this._criaNegociacao());
		this._negociacoesView.update(this._listaNegociacoes);
		
		this._mensagem.texto = "Negociação adicionada com sucesso!";
		this._mensagemView.update(this._mensagem);
		
		this._limpaFormulario();
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