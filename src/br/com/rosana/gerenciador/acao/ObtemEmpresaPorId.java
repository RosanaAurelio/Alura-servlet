package br.com.rosana.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rosana.gerenciador.modelo.Banco;
import br.com.rosana.gerenciador.modelo.Empresa;

public class ObtemEmpresaPorId implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Integer paramId = Integer.parseInt(request.getParameter("id"));
				
		Banco banco = new Banco();
		Empresa empresa = banco.obtemEmpresaPorID(paramId);
		request.setAttribute("empresa", empresa);
		
		return "foward:WEB-INF/view/EditaEmpresaForm.jsp";
	}
}
