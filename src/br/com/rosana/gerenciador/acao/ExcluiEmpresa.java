package br.com.rosana.gerenciador.acao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rosana.gerenciador.modelo.Banco;

public class ExcluiEmpresa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Integer paramId = Integer.parseInt(request.getParameter("id"));
		
		Banco banco = new Banco();
		banco.removeEmpresaPorId(paramId);
		
		return "redirect:controller?acao=ListaEmpresas";
	}
}
