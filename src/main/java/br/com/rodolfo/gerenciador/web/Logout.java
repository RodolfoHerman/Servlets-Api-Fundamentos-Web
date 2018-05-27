package br.com.rodolfo.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Logout
 */
@WebServlet(urlPatterns="/logout")
public class Logout extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();

        //Buscar usuario logado se houver
        Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();

        if(cookie != null) {
            
            //Colocar o tempo de vida do cookie para zero
            cookie.setMaxAge(0);

            //Retornar o cookie com o tempo de validade zerado
            resp.addCookie(cookie);
        }

        writer.println("<html><body>Deslogado com sucesso !!</body></html>");
    }
}