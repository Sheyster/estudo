var tabela = document.querySelector("table");

tabela.addEventListener("dblclick", function(event) {
	event.target.parentNode.classList.add("fadeOut");

	var alvoEvento = event.target;
	var paiDoAlvo = alvoEvento.parentNode;
	if (paiDoAlvo) {

	}
	setTimeout(function() {
		paiDoAlvo.remove();
	}, 500);
});