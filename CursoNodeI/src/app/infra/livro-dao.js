class LivroDao {

    constructor (db) {
        this._db = db;
    }

    lista(callback) {
        this._db.all('select * from livros ', (err, result) =>
            callback(err, result)
        );
    }
}

module.exports = LivroDao;