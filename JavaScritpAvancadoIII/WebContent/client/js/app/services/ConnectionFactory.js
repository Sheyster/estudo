// fazendo desta forma eu torno a classe privada. padrão = module pater
var ConnectionFactory = (function () {

    // const não permite você reatribuir o valor de uma variavel
    const stores = ['negociacoes'];
    const version = 4;
    const dbName = 'aluraframe';

    var connection = null;
    var close = null;

    return class ConnectionFactory {

        // a) getConnection vai ser um método estático
        // b) getConnection vai retornar uma promise
        // c) não importa o número de vezes que eu chamar o método estático, a conexão sempre será a mesma
        // d) o programado não pode chamar o close diretamente. Ela só pode ser fechada pela própria ConnectionFactory 

        constructor() {
            throw new Error('Não é possível criar instâncias de ConnectionFactory!');
        }

        static getConnection() {
            return new Promise((resolve, reject) => {
                let openRequest = window.indexedDB.open(dbName, version);

                openRequest.onupgradeneeded = e => {
                    ConnectionFactory._createStore(e.target.result);

                    // stores.forEach(store => {
                    // if (e.target.result.objectStoreNames.contains(store)) {
                    //     e.target.deleteObjectStore(store);
                    // }

                    // e.target.result.createobjectStore(store, { autoIncrement: true });
                    // });
                };

                openRequest.onsuccess = e => {
                    if (!connection) {
                        connection = e.target.result;
                        close = connection.close.bind(connection);
                        connection.close = function () {
                            throw new Error('Você não pode fechar diretamente a conexão.');
                        };
                    }
                    resolve(connection);
                };

                openRequest.onerror = e => {
                    console.log(e.target.error);
                    reject(e.target.error.name);
                };
            });
        }

        static _createStore(connection) {
            stores.forEach(store => {
                if (connection.objectStoreNames.contains(store)) {
                    connection.deleteObjectStore(store);
                }

                connection.createObjectStore(store, { autoIncrement: true });
            });
        }

        static closeConnection() {
            if (connection) {
                close();
                connection = null;
            }
        }
    }
})();

//var ConnectionFactory = tmp();