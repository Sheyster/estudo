class NegociacaoService {
	
	obterNegociacoesDaSemana(){
		
		return new Promise((resolve, reject) => {
			
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
						
						resolve(JSON.parse(xhr.responseText).map(objeto => new Negociacao(new Date(objeto.data), objeto.quantidade, objeto.valor)));
					} else {
						console.log("Não foi possível obter as negociações do servidor.");
						console.log(xhr.responseText);
						reject("Não foi possível obter as negociações.")
					}
				}
				
			};
			
			xhr.send();
		});
		
	}
}