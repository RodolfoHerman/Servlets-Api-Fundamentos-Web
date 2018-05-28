package br.com.rodolfo.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rodolfo.gerenciador.Empresa;
import br.com.rodolfo.gerenciador.dao.EmpresaDAO;

/**
 * NovaEmpresa
 */
//@WebServlet(urlPatterns="/novaEmpresa") --> Com a nova lógica de MVC irá implmenetar a interface TAREFA
public class NovaEmpresa implements Tarefa {

    //Toda a lógica do DISPATCHER foi colocada no CONTROLLER
    public String executa(HttpServletRequest req, HttpServletResponse resp) {
        
        String nome = req.getParameter("nome");
        Empresa empresa = new Empresa(nome);
        new EmpresaDAO().adiciona(empresa);
        req.setAttribute("empresa", empresa);

        return "/WEB-INF/paginas/novaEmpresa.jsp";
    }

    //Com a nova lógica do MVC essa classe irá implementar o método executa da interface TAREFA
    //Quando acessamos uma URI diretamente no navegador, estamos efetuando um GET de uma URI
    //@Override
    //protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Realizar a leitura do parâmetro da URI de nome 'nome'
        //--->String nome = req.getParameter("nome");

        //--->Empresa empresa = new Empresa(nome);

        //--->new EmpresaDAO().adiciona(empresa);

        //Devolver uma mensagem de sucesso para o cliente
        //PrintWriter writer = resp.getWriter();

        //writer.println("<html><body>Empresa salva com suceso : " + nome + "</body></html>");

        //Colocar o objeto que será utilizado na VIEW dentro do request que será acessado na página JSP
        //por meio da EXPRESSION LANGUAGE ${}.
        //A HttpServletRequest permite o armazenamento de valores que duram somente o 
        //ciclo de uma requisição - uma ida ao servidor e volta ao cliente, 
        //incluindo redirecionamentos do tipo server side, que estamos usando.
        //--->req.setAttribute("empresa", empresa);

        //--->RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
        //--->dispatcher.forward(req, resp);
    //}
    
}