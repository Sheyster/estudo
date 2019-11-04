const LivroDao = require('../infra/livro-dao');
const db = require('../../config/database');

module.exports = (app) => {

    app.get('/', function (req, resp) {
        resp.send(`
            <html> 
                <head>
                    <meta charset="utf-8"></meta>
                </head>
                <body>
                    <h1> Teste Node I</h1>
                </body>
            </html>
        `);
    });

    app.get('/livros', function (req, resp) {

        const livroDao = new LivroDao(db);
        livroDao.lista(function (err, result) {
            resp.marko(
                require('../view/livros/lista/lista.marko'),
                {
                    livros: result
                }
            );
        });

        // db.all('select * from livros ', function (err, result) {
        //     resp.marko(
        //         require('../view/livros/lista/lista.marko'),
        //         {
        //             livros: result
        //         }
        //     );
        // });
    });

}
