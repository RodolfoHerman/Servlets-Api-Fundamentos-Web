package br.com.rodolfo.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rodolfo.gerenciador.Empresa;
import br.com.rodolfo.gerenciador.dao.EmpresaDAO;

/**
 * NovaEmpresa
 */
@WebServlet(urlPatterns="/novaEmpresa")
public class NovaEmpresa extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Realizar a leitura do parâmetro da URI de nome 'nome'
        String nome = req.getParameter("nome");

        Empresa empresa = new Empresa(nome);

        new EmpresaDAO().adiciona(empresa);

        //Devolver uma mensagem de sucesso para o cliente
        //PrintWriter writer = resp.getWriter();

        //writer.println("<html><body>Empresa salva com suceso : " + nome + "</body></html>");

        //Colocar o objeto que será utilizado na VIEW dentro do request que será acessado na página JSP
        //por meio da EXPRESSION LANGUAGE ${}.
        //A HttpServletRequest permite o armazenamento de valores que duram somente o 
        //ciclo de uma requisição - uma ida ao servidor e volta ao cliente, 
        //incluindo redirecionamentos do tipo server side, que estamos usando.
        req.setAttribute("empresa", empresa);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
        dispatcher.forward(req, resp);
    }
    
}