package br.com.rodolfo.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rodolfo.gerenciador.Empresa;
import br.com.rodolfo.gerenciador.dao.EmpresaDAO;

/**
 * BuscaEmpresa
 */
//Informamos a URI de acesso ao Servlet
@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa extends HttpServlet{

    //Quando acessamos uma URI diretamente no navegador, estamos efetuando um GET de uma URI
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter writer = resp.getWriter();

        writer.println("<html>");
        writer.println("<body>");
        writer.println("Resultado da busca:<br/>");

        String filtro = req.getParameter("filtro");

        Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);

        writer.println("<ul>");

        for (Empresa empresa : empresas) {
            
            writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");

        }

        writer.println("</ul>");

        writer.println("</body>");
        writer.println("</html>");

    }

    //Diretórios dentro de WebContent que não são acessíveis para o cliente final via a URI
    //WEB-INF e o META-INF 
    //http://devcanvas.org/deploy-a-web-application-from-the-command-line-by-using-tomcat-maven-plugin/
}