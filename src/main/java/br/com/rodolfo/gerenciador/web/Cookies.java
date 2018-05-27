package br.com.rodolfo.gerenciador.web;

import javax.servlet.http.Cookie;

/**
 * Cookies: o problema de se usar cookies é que toda requisição o enviará e o receberá
 * os dados novamente, quanto maior o cookie mais lenta será a requisição.
 * Classe responsável por tratar os cookies
 */
public class Cookies {

    private final Cookie[] cookies;

    public Cookies(Cookie[] cookies) {

        this.cookies = cookies;
    }

    public Cookie buscaUsuarioLogado() {

        if(this.cookies == null) {

            return null;
        }

        for (Cookie cookie : this.cookies) {
            
            if(cookie.getName().equals("usuarioLogado")) {

                return cookie;
            }
        }

        return null;
    }
    
}