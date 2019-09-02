var titulo = document.querySelector(".titulo");
titulo.textContent = "Aparecida Nutricionista";

var pacientes = document.querySelectorAll(".paciente");

for (var i = 0; i < pacientes.length; i++) {

	var tdPeso = pacientes[i].querySelector(".info-peso");
	var tdAltura = pacientes[i].querySelector(".info-altura");
	var tdImc = pacientes[i].querySelector(".info-imc");

	var peso = parseInt(tdPeso.textContent);
	var altura = parseFloat(tdAltura.textContent);
	var pesoEhValido = validaPeso(peso);
	var alturaEhValido = validaAltura(altura);

	if (!pesoEhValido) {
		tdImc.textContent = "Peso inválido!";
		pacientes[i].classList.add("paciente-invalido");
	}

	if (!alturaEhValido) {
		tdImc.textContent = "Altura inválida!";
		pacientes[i].classList.add("paciente-invalido");
	}

	if (pesoEhValido && alturaEhValido) {
		var resultImc = calculaImc(peso, altura);
		tdImc.textContent = resultImc;
	}
}

function validaPeso(peso) {
	if (peso >= 0 && peso < 1000) {
		return true;
	} else {
		return false;
	}
}

function validaAltura(altura) {
	if (altura >= 0 && altura < 3.0) {
		return true;
	} else {
		return false;
	}
}

function calculaImc(peso, altura) {
	var imc = 0;

	imc = peso / (altura * altura);

	return imc.toFixed(2);
}