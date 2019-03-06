package br.com.rosana.gerenciador.acao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rosana.gerenciador.modelo.Banco;
import br.com.rosana.gerenciador.modelo.Empresa;

public class IncluiEmpresa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("dataAbertura");
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData); 
		}catch(ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa(paramNome, dataAbertura);
		Banco banco = new Banco();
		banco.adicionaEmpresa(empresa);
		
		return "redirect:controller?acao=ListaEmpresas";
	}
}
