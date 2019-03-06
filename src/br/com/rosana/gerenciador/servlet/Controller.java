package br.com.rosana.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rosana.gerenciador.acao.Acao;

@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String className = "br.com.rosana.gerenciador.acao."+ request.getParameter("acao");
		
		Class classe;
		try {
			classe = Class.forName(className);			
			
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
		String retornoAcao = "";		
		try {
			Acao acao = (Acao)classe.newInstance();
			retornoAcao = acao.executa(request, response);			
		} catch (InstantiationException e) {
			throw new ServletException(e);
		} catch (IllegalAccessException e) {
			throw new ServletException(e);
		}
		
		String[] tipoEEndereco = retornoAcao.split(":");
		if (tipoEEndereco[0].equals("redirect")) {
			response.sendRedirect(tipoEEndereco[1]);
		}else {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(tipoEEndereco[1]);
			requestDispatcher.forward(request, response);
		}
	}
}