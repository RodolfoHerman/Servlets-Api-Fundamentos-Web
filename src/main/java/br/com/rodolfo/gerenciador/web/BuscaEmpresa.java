package br.com.rodolfo.gerenciador.web;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rodolfo.gerenciador.Empresa;
import br.com.rodolfo.gerenciador.dao.EmpresaDAO;

/**
 * BuscaEmpresa
 */
//Informamos a URI de acesso ao Servlet
//@WebServlet(urlPatterns="/busca") --> Com a nova lógica de MVC irá implmenetar a interface TAREFA
public class BuscaEmpresa implements Tarefa{

    //Toda a lógica do DISPATCHER foi colocada no CONTROLLER
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String filtro = req.getParameter("filtro");
        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
        req.setAttribute("empresas", empresas);

        return "/WEB-INF/paginas/buscaEmpresa.jsp";
    }

    //Com a nova lógica do MVC essa classe irá implementar o método executa da interface TAREFA
    //Quando acessamos uma URI diretamente no navegador, estamos efetuando um GET de uma URI
    // @Override
    // protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    //     String filtro = req.getParameter("filtro");

    //     Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

    //     //Utilizar paginas dinamicas para mostrar o conteudo
    //     {
    //         // PrintWriter writer = resp.getWriter();

    //         // writer.println("<html>");
    //         // writer.println("<body>");
    //         // writer.println("Resultado da busca:<br/>");

    //         // writer.println("<ul>");

    //         // for (Empresa empresa : empresas) {
                
    //         //     writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");

    //         // }

    //         // writer.println("</ul>");

    //         // writer.println("</body>");
    //         // writer.println("</html>");
    //     }

    //     req.setAttribute("empresas", empresas);

    //     RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
    //     dispatcher.forward(req, resp);

    // }

    //Diretórios dentro de WebContent que não são acessíveis para o cliente final via a URI
    //WEB-INF e o META-INF 
    //http://devcanvas.org/deploy-a-web-application-from-the-command-line-by-using-tomcat-maven-plugin/
}