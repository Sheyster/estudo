class Negociacao {
	constructor(data, quantidade, valor){
		this._data = new Date(data.getTime()); // Isso é para garantir que não
												// será alterada via setDate na
												// aplicação
		this._quantidade = quantidade;
		this._valor = valor;
		Object.freeze(this);  /*
								 * Essa funcao faz com não consigamos alterar o
								 * valor de um atributo de uma classe, similar
								 * ao private do Java
								 */
	}
	
	get volume(){
		return this._quantidade * this._valor;
	}
	
	get data(){
		return new Date(this._data.getTime()); // Isso é para garantir que não
												// será alterada via setDate na
												// aplicação
	}
	
	get quantidade(){
		return this._quantidade;
	}
	
	get valor(){
		return this._valor;
	}
}