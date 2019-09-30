class ListaNegociacoes {
	
	constructor() {
		this._negociacoes = [];
	}
	
	adiciona(negociacao){
		// forçando a chamada da atribuição a negociações
		// Iss não é utilizado pois se tivessemos uma lista com mil negociações, estaríamos criando uma negociação a cada chamanda
		this._negociacoes = [].concat(this._negociacoes, negociacao);
		
// this._negociacoes.push(negociacao);
	}
	
	get negociacoes(){
		// Programacao defensiva
		return [].concat(this._negociacoes);
	}
	
	esvazia(){
		this._negociacoes = [];
	}
	
	// novo método
    get volumeTotal() {
       return this._negociacoes.reduce((total, n) => total + n.volume, 0.0);
    }
	
	ordena(criterio) {
        this._negociacoes.sort(criterio);        
    }
	
	inverteOrdem() {
        this._negociacoes.reverse();
    }
}