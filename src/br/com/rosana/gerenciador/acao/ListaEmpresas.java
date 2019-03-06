package br.com.rosana.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rosana.gerenciador.modelo.Banco;

public class ListaEmpresas implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		Banco banco = new Banco();
		request.setAttribute("empresas", banco.getEmpresas());
		return "foward:WEB-INF/view/ListaEmpresasForm.jsp";
	}
}
