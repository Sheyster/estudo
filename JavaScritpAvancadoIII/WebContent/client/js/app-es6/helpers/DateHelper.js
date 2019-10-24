class DateHelper {
	
	constructor() {
		throw new Error("DateHelper não pode ser instânciada!");
	}
	
	static dataParaTexto(data) {
		return `${data.getDate()}/${data.getMonth()+1}/${data.getFullYear()}`;
		// outra forma de escrever o mesmo código abaixo! Utilizando "template string"
// return data.getDate() + "/" + (data.getMonth() + 1) + "/" + data.getFullYear();
	}
	
	static textoParaData(texto) {
		// Expressão regular
		if(!/\d{2}\/\d{2}\/\d{4}/.test(texto)){
			throw new Error("A data deve estar no formado aaaa-mm-dd!");
		}
		 // veja que usamos no split '/' no lugar de '-'. Usamos `reverse` também para ficar ano/mes/dia.
		return new Date(...texto.split("/").reverse().map((item, indice) => item - indice % 2));
	}
}