package br.com.rosana.gerenciador.acao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rosana.gerenciador.modelo.Banco;
import br.com.rosana.gerenciador.modelo.Empresa;

public class EditaEmpresa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		Integer paramId = Integer.parseInt(request.getParameter("id"));
		String paramNome = request.getParameter("nome");
		String paramData = request.getParameter("dataAbertura");
		
		Banco banco = new Banco();
		Empresa empresa = banco.obtemEmpresaPorID(paramId);
		request.setAttribute("empresa", empresa);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramData); 
		}catch(ParseException e) {
			throw new ServletException(e);
		}
		
		empresa.setDataAbertura(dataAbertura);
		empresa.setNome(paramNome);
		
		return "redirect:controller?acao=ListaEmpresas";
	}
}
