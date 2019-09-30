if (!Array.prototype.includes) {
	// Se não existir, adiciona
	console.log("Pollyfill para Array.includes aplicado");

	Array.protoype.includes = function(elemento) {
		return this.indexOf(elemento) != -1;
	};
}