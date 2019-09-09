<<<<<<< HEAD
class MensagemView extends View{

	constructor(elemento) {
		super(elemento);
	}
	
	_template(model) {
		return model.texto ? `<p class="alert alert-info"> ${model.texto} </p>` : "<p></p>";
=======
class MensagemView {

	constructor(elemento) {
		this._elemento = elemento;
	}
	
	_template(model) {
		return model.texto ? `<p class="alert alert-info"> ${model.texto} </p>` : "<p></p>";
	}
	
	update(model) {
		this._elemento.innerHTML = this._template(model);
>>>>>>> branch 'master' of https://github.com/Sheyster/estudo.git
	}
}