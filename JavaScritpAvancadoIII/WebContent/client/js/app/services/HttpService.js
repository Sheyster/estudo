'use strict';

System.register([], function (_export, _context) {
		"use strict";

		var _createClass, HttpService;

		function _classCallCheck(instance, Constructor) {
				if (!(instance instanceof Constructor)) {
						throw new TypeError("Cannot call a class as a function");
				}
		}

		return {
				setters: [],
				execute: function () {
						_createClass = function () {
								function defineProperties(target, props) {
										for (var i = 0; i < props.length; i++) {
												var descriptor = props[i];
												descriptor.enumerable = descriptor.enumerable || false;
												descriptor.configurable = true;
												if ("value" in descriptor) descriptor.writable = true;
												Object.defineProperty(target, descriptor.key, descriptor);
										}
								}

								return function (Constructor, protoProps, staticProps) {
										if (protoProps) defineProperties(Constructor.prototype, protoProps);
										if (staticProps) defineProperties(Constructor, staticProps);
										return Constructor;
								};
						}();

						_export('HttpService', HttpService = function () {
								function HttpService() {
										_classCallCheck(this, HttpService);
								}

								_createClass(HttpService, [{
										key: '_handleErrors',
										value: function _handleErrors(res) {
												if (res.ok) {
														return res;
												} else {
														throw new Error(res.statusText);
												}
										}
								}, {
										key: 'get',
										value: function get(url) {
												var _this = this;

												return fetch(url).then(function (res) {
														return _this._handleErrors(res);
												}).then(function (res) {
														return res.json();
												});

												// return new Promise((resolve, reject) => {
												// 	let xhr = new XMLHttpRequest();
												// 	xhr.open("GET", url);

												// 	xhr.onreadystatechange = () => {
												// 		/*
												// 		 * 0: requisição ainda não iniciada
												// 		 * 
												// 		 * 1: conexão com o servidor estabelecidad
												// 		 * 
												// 		 * 2: requisição recebida
												// 		 * 
												// 		 * 3: processando requisição
												// 		 * 
												// 		 * 4: requisição concluida e a resposta esta pronta
												// 		 */
												// 		if(xhr.readyState == 4){
												// 			if(xhr.status == 200){
												// 				console.log("Obtendo as negociações do servidor.");
												// 				console.log(JSON.parse(xhr.responseText));

												// 				resolve(JSON.parse(xhr.responseText));
												// 			} else {
												// 				console.log("Não foi possível obter as negociações do servidor.");
												// 				console.log(xhr.responseText);
												// 				reject(xhr.responseText)
												// 			}
												// 		}

												// 	};

												// 	xhr.send();
												// });
										}
								}, {
										key: 'post',
										value: function post(url, dado) {
												var _this2 = this;

												return fetch(url, {
														headers: { 'Content-type': 'application/json' },
														method: 'post',
														body: JSON.stringify(dado)
												}).then(function (res) {
														return _this2._handleErrors(res);
												});

												// return new Promise((resolve, reject) => {

												// 	let xhr = new XMLHttpRequest();
												// 	xhr.open("POST", url, true);
												// 	xhr.setRequestHeader("Content-type", "application/json");
												// 	xhr.onreadystatechange = () => {

												// 		if (xhr.readyState == 4) {

												// 			if (xhr.status == 200) {

												// 				resolve(JSON.parse(xhr.responseText));
												// 			} else {

												// 				reject(xhr.responseText);
												// 			}
												// 		}
												// 	};
												// 	xhr.send(JSON.stringify(dado)); // usando JSON.stringify para converter objeto em uma string no formato JSON.
												// });
												/*
              * return new Promise((resolve, reject) => {
              * 
              * let xhr = new XMLHttpRequest(); xhr.open("POST", url, true); xhr.setRequestHeader("Content-Type", "application/json");
              * 
              * });
              */
										}
								}]);

								return HttpService;
						}());

						_export('HttpService', HttpService);
				}
		};
});
//# sourceMappingURL=HttpService.js.map