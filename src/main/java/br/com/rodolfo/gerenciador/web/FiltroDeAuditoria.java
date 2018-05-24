package br.com.rodolfo.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * FiltroDeAuditoria
 */
//Todos os Servlets irão passar pelo filtro (doFilter) e mostra a URI acessada pelo usuário
//Os filtros são aplicados para ter controle no acesso aos servlets e páginas. Utilizado em aplicações
//web como uma maneirda de adicionar características a parte da aplicação
//Filters também são cahamdos de Interceptors
@WebFilter(urlPatterns="/*")
public class FiltroDeAuditoria implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) request;

        String uri = req.getRequestURI();

        //Imprimi o acesso das URI's feitas pelo usuário
        System.out.println("Usuário acessando URI : " + uri);

        //Necessário informar que é necessário continuar com o fluxo normal da aplicação, caso contrário, o servidor iria printar a URI do cod. acima e iria parar a aplicação.
        chain.doFilter(request, response);

	}

	public void destroy() {
		
	}


    
}