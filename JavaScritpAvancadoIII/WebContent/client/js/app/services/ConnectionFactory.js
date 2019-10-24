'use strict';

var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

// fazendo desta forma eu torno a classe privada. padrão = module pater
var ConnectionFactory = function () {

    // const não permite você reatribuir o valor de uma variavel
    var stores = ['negociacoes'];
    var version = 4;
    var dbName = 'aluraframe';

    var connection = null;
    var close = null;

    return function () {

        // a) getConnection vai ser um método estático
        // b) getConnection vai retornar uma promise
        // c) não importa o número de vezes que eu chamar o método estático, a conexão sempre será a mesma
        // d) o programado não pode chamar o close diretamente. Ela só pode ser fechada pela própria ConnectionFactory 

        function ConnectionFactory() {
            _classCallCheck(this, ConnectionFactory);

            throw new Error('Não é possível criar instâncias de ConnectionFactory!');
        }

        _createClass(ConnectionFactory, null, [{
            key: 'getConnection',
            value: function getConnection() {
                return new Promise(function (resolve, reject) {
                    var openRequest = window.indexedDB.open(dbName, version);

                    openRequest.onupgradeneeded = function (e) {
                        ConnectionFactory._createStore(e.target.result);

                        // stores.forEach(store => {
                        // if (e.target.result.objectStoreNames.contains(store)) {
                        //     e.target.deleteObjectStore(store);
                        // }

                        // e.target.result.createobjectStore(store, { autoIncrement: true });
                        // });
                    };

                    openRequest.onsuccess = function (e) {
                        if (!connection) {
                            connection = e.target.result;
                            close = connection.close.bind(connection);
                            connection.close = function () {
                                throw new Error('Você não pode fechar diretamente a conexão.');
                            };
                        }
                        resolve(connection);
                    };

                    openRequest.onerror = function (e) {
                        console.log(e.target.error);
                        reject(e.target.error.name);
                    };
                });
            }
        }, {
            key: '_createStore',
            value: function _createStore(connection) {
                stores.forEach(function (store) {
                    if (connection.objectStoreNames.contains(store)) {
                        connection.deleteObjectStore(store);
                    }

                    connection.createObjectStore(store, { autoIncrement: true });
                });
            }
        }, {
            key: 'closeConnection',
            value: function closeConnection() {
                if (connection) {
                    close();
                    connection = null;
                    close = null;
                }
            }
        }]);

        return ConnectionFactory;
    }();
}();

//var ConnectionFactory = tmp();
//# sourceMappingURL=ConnectionFactory.js.map