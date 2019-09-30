class NegociacaoService {
	
	constructor() {
		this._http = new HttpService();
	}
	
	obterNegociacoesDaSemana(){
		return new Promise((resolve, reject) => {
			this._http.get("negociacoes/semana")
			.then(negociacoes => {
				resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
			})
			.catch(err => {
				console.log(err);
				reject("Não foi possivel obter as negociações da semana");
			});
		});
		/*
		 * return new Promise((resolve, reject) => {
		 * 
		 * let xhr = new XMLHttpRequest(); xhr.open("GET", "negociacoes/semana");
		 * 
		 * xhr.onreadystatechange = () => {
		 * 
		 * 0: requisição ainda não iniciada
		 * 
		 * 1: conexão com o servidor estabelecidad
		 * 
		 * 2: requisição recebida
		 * 
		 * 3: processando requisição
		 * 
		 * 4: requisição concluida e a resposta esta pronta
		 * 
		 * if(xhr.readyState == 4){ if(xhr.status == 200){ console.log("Obtendo as negociações do servidor."); console.log(JSON.parse(xhr.responseText));
		 * 
		 * resolve(JSON.parse(xhr.responseText).map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor))); } else { console.log("Não foi possível obter
		 * as negociações do servidor."); console.log(xhr.responseText); reject("Não foi possível obter as negociações.") } } };
		 * 
		 * xhr.send(); });
		 */
		
	}
	
	obterNegociacoesDaSemanaAnterior(){
		return new Promise((resolve, reject) => {
			this._http.get("negociacoes/anterior")
			.then(negociacoes => {
				resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
			})
			.catch(err => {
				console.log(err);
				reject("Não foi possivel obter as negociações da semana anterior");
			});
		});
	}
	
	obterNegociacoesDaSemanaRetrasada(){
		return new Promise((resolve, reject) => {
			this._http.get("negociacoes/retrasada")
			.then(negociacoes => {
				resolve(negociacoes.map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
			})
			.catch(err => {
				console.log(err);
				reject("Não foi possivel obter as negociações da semana retrasada");
			});
		});
	}
}