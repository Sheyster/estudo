const LivroControlador = require('./livro-controlador');

const templates = require('../views/templates');

class BaseControlador {
    static rotas() {
        return {
            home: '/',
            login: '/login'
        };
    }

    home() {
        return function (req, resp) {
            resp.marko(
                templates.base.home
            );
        };
    }

    login() {
        return function (req, resp) {
            resp.marko(
                templates.base.login
            );
        };
    }

    efetuarLogin() {
        return function (req, resp, next) {
            const passport = req.passport;

            passport.authenticate('local', (err, usuario, info) => {
                if (info) {
                    return resp.marko(templates.base.login);
                }

                if (err) {
                    return next(err);
                }

                req.login(usuario, (err) => {
                    if (err) {
                        return next(err);
                    }

                    return resp.redirect(LivroControlador.rotas().lista);
                });
            })(req, resp, next);
        };
    }
}

module.exports = BaseControlador;