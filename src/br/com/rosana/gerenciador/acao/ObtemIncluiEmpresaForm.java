package br.com.rosana.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ObtemIncluiEmpresaForm implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		
		return "foward:WEB-INF/view/NovaEmpresaForm.jsp";
	}

}
