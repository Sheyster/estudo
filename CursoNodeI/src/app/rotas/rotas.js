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

        livroDao.lista()
            .then(livros => resp.marko(
                require('../view/livros/lista/lista.marko'),
                {
                    livros: livros
                }
            ))
            .catch(err => console.log(err));

        // livroDao.lista(function (err, result) {
        //     resp.marko(
        //         require('../view/livros/lista/lista.marko'),
        //         {
        //             livros: result
        //         }
        //     );
        // });

        // db.all('select * from livros ', function (err, result) {
        //     resp.marko(
        //         require('../view/livros/lista/lista.marko'),
        //         {
        //             livros: result
        //         }
        //     );
        // });
    });

    app.get('/livros/form', function (req, resp) {
        resp.marko(require('../view/livros/form/form.marko'), { livro: {} });
    });

    app.get('/livros/form/:id', function (req, resp) {
        const id = req.params.id;
        const livroDao = new LivroDao(db);

        livroDao.buscaPorId(id)
            .then(livro =>
                resp.marko(
                    require('../view/livros/form/form.marko'),
                    { livro: livro }
                )
            )
            .catch(erro => console.log(erro));

    });

    app.post('/livros', function (req, resp) {
        console.log(req.body);

        const livroDao = new LivroDao(db);
        livroDao.adiciona(req.body)
            .then(resp.redirect('/livros'))
            .catch(err => console.log(err));
    });

    app.put('/livros', function (req, resp) {
        console.log(req.body);

        const livroDao = new LivroDao(db);
        livroDao.atualiza(req.body)
            .then(resp.redirect('/livros'))
            .catch(err => console.log(err));
    });

    app.delete('/livros/:id', function (req, resp) {
        const id = req.params.id;
        const livroDao = new LivroDao(db);

        livroDao.remove(id)
            .then(() => resp.status(200).end())
            .catch(err => console.log(err));
    });
}
