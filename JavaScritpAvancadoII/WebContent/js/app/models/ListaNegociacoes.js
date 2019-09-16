class ListaNegociacoes {
	
	constructor() {
		this._negociacoes = [];
	}
	
	adiciona(negociacao){
		this._negociacoes.push(negociacao);
	}
	
	get negociacoes(){
		// Programacao defensiva
		return [].concat(this._negociacoes);
	}
	
	esvazia(){
		this._negociacoes = [];
	}
}