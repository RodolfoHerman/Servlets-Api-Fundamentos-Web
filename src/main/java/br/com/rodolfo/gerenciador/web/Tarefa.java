package br.com.rodolfo.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Tarefa
 */
public interface Tarefa {

    public String executa(HttpServletRequest req, HttpServletResponse resp);

}