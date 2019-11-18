const app = require('./src/config/custom-express');

app.listen(3000, function () {
    console.log('Servidor rodando na porta 3000!');
});



// const http = require('http');

// const servidor = http.createServer(function (req, resp){
//     resp.end(`
//         <html> 
//             <head>
//                 <meta charset="utf-8"></meta>
//             </head>
//             <body>
//                 <h1> Teste Node I</h1>
//             </body>
//         </html>
//     `);
// }).listen(3000, 'localhost');
//servidor.listen(3000);