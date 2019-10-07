class NegociacaoDao {

    constructor(connection) {
        this._connection = connection;
        this._store = 'negociacoes';
    }

    adiciona(negociacao) {
        return new Promise((resolve, reject) => {

            // pode ser feito desta forma ou da forma sequinte encadeando.
            //let transaction = this._connection.transaction([this._store], 'readwrite');
            //let store = transaction.objectStore(this._store);
            //let request = store.add(negociacao);

            let request = this._connection.transaction([this._store], 'readwrite').objectStore(this._store).add(negociacao);

            request.onsuccess = e => {
                resolve();
                console.log('Negociação incluida com sucesso!');
            };

            request.onerror = e => {
                console.log(e.target.error);
                reject('Não foi possível adicionar a negocição.');
            };
        });
    }
}