package br.com.rodolfo.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Logout
 */
//@WebServlet(urlPatterns="/logout") --> Com a nova lógica de MVC irá implmenetar a interface TAREFA
public class Logout implements Tarefa {

    //Toda a lógica do DISPATCHER foi colocada no CONTROLLER
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        req.getSession().removeAttribute("usuarioLogado");
        return "/WEB-INF/paginas/logout.html";
    }

    //Com a nova lógica do MVC essa classe irá implementar o método executa da interface TAREFA
    //Quando acessamos uma URI diretamente no navegador, estamos efetuando um GET de uma URI
    //@Override
    //protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //PrintWriter writer = resp.getWriter();

        //Trabalhar com SESSION ao invés de COOKIES
        //{
            //Buscar usuario logado se houver
            // Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();

            // if(cookie != null) {
                
            //     //Colocar o tempo de vida do cookie para zero
            //     cookie.setMaxAge(0);

            //     //Retornar o cookie com o tempo de validade zerado
            //     resp.addCookie(cookie);
            // }
        //}

        //O problema de invalidar a sessão é que irá remover todos os valores da sessão do HashMap
        //não somente o valor "usuario.logado"
        //req.getSession().invalidate();

        //---> req.getSession().removeAttribute("usuarioLogado");

        //Redirecionamento do lado do cliente, o problema aqui é que a página fica
        //na pasta webapp e se o usuário digitar http://localhost:8080/gerenciador/logout.html 
        //ele terá acesso a página o que ocasiona um erro de fluxo pois pra que acessar tal página 
        //se o usuário não estiver logado ou caso seja uma página protegida um erro de autenticação.
        //É realizado o código 302 (redirect), caminho relativo
        //resp.sendRedirect("logout.html");

        //Redirecionamento do lado do servidor. Agora com a página no deretório WEB-INF (usuário não possui acesso). Escondemos do usuário a página e não é realizado o redirect de código 302
        //---> RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");

        //---> dispatcher.forward(req, resp);

        //Não é necessário por causa do redirect
        //writer.println("<html><body>Deslogado com sucesso !!</body></html>");
    //}
}