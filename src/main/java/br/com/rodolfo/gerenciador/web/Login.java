package br.com.rodolfo.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.rodolfo.gerenciador.Usuario;
import br.com.rodolfo.gerenciador.dao.UsuarioDAO;

/**
 * Login
 */
@WebServlet(urlPatterns="/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter writer = resp.getWriter();

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        Usuario usuario = new UsuarioDAO().buscaPorEmailESenha(email, senha);

        if(usuario == null) {

            writer.println("<html><body>Usuario ou senha invalido</body></html>");

        } else {

            //Utilizar SESSEION para marcar o usuário logado
            {
                //Criar um cookie com as credenciais do usuário
                //Cookie cookie = new Cookie("usuario.logado", email);

                //Setar o tempo de vida do cookie em 10 minutos (60 segundos * 10)
                //cookie.setMaxAge(60 * 10);

                //Retornar o cookie para ser setado no cliente
                //resp.addCookie(cookie);
            }

            //Pegar a session do usuário logado. O objeto HttpSession tem a vantagem
            //de enviar menos informações entre as transações de response e request, ela atualiza de forma automática
            //o tempo de vida do usuário logado, tem controle de concorrência para acessa-la.
            HttpSession session = req.getSession();

            //Como a informação de sessão fica do lado do servidor pode-se guardar o OBJETO USUARIO
            session.setAttribute("usuario.logado", usuario);

            writer.println("<html><body>Usuario logado : " + email + "</body></html>");
        }

    }
    
}