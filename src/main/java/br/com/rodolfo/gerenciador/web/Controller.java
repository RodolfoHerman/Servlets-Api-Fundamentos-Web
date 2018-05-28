package br.com.rodolfo.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Controller
 */
@WebServlet(urlPatterns="/executa")
public class Controller extends HttpServlet {

    //Service ao contrário do doGet e doPost ela captura todos os cassos do verbo HTTP
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
    
        //Pegar o parâmetro do que será executado
        String tarefa = req.getParameter("tarefa");

        if(tarefa == null) {
            throw new IllegalArgumentException("Esuqceu de passar a tarefa !");
        }

        //Qual tarefa será executada. Buscamos a classe a ser executada a partir da tarefa solicitada
        tarefa = "br.com.rodolfo.gerenciador.web." + tarefa;

		try {
            //Api baseado no valor da String consegue realizar a instancia de uma classe/objeto
            Class<?> tipo = Class.forName(tarefa);
            
            //Realizar a instancia da classe e cast para Tarefa para deixa-la de forma generica e utilizar
            //o método comum "executa()" em todas as instancias de classe 
            Tarefa instancia = (Tarefa) tipo.newInstance();

            //Para onde deve ser direcionado
            String pagina = instancia.executa(req, resp);    

            //Para onde será redirecionado
            RequestDispatcher dispatcher = req.getRequestDispatcher(pagina);
            dispatcher.forward(req, resp);

        } catch (ClassNotFoundException  e) {
            
            throw new ServletException(e);
		} catch (IllegalAccessException e) {
            
            throw new ServletException(e);
        } catch(InstantiationException e) {
            
            throw new ServletException(e);
        }

    }
    
}