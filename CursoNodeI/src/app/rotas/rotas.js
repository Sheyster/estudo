module.exports = (app) => {
    app.get('/', function (req, resp) {
        resp.marko(
            require('../view/livros/lista/lista.marko'),
            {
                livros: [
                    {
                        id: 1, titulo: 'Fundamentos do Node'
                    },
                    {
                        id: 2, titulo: 'Node Avançado'
                    }]
            }
        );
    });

    // app.get('/', function (req, resp) {
    //     resp.send(`
    //         <html> 
    //             <head>
    //                 <meta charset="utf-8"></meta>
    //             </head>
    //             <body>
    //                 <h1> Teste Node I</h1>
    //             </body>
    //         </html>
    //     `);
    // });
}
