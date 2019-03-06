package br.com.rosana.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Banco {
	private static Integer chave = 1;
	private static List<Empresa> empresas = new ArrayList<>();

	static {
		Empresa empresa1 = new Empresa("Pringles", new Date());
		empresa1.setId(chave++);
		empresas.add(empresa1);
		
		Empresa empresa2 = new Empresa("Tomcat", new Date());
		empresa2.setId(chave++);
		empresas.add(empresa2);
	}
	
	
	public void adicionaEmpresa(Empresa empresa) {
		empresa.setId(chave++);
		empresas.add(empresa);
	}
	
	public List<Empresa> getEmpresas(){
		return empresas;
	}
	
	public Empresa obtemEmpresaPorID(Integer id) {
		for (Empresa empresa:empresas) {
			if (empresa.getId() == id)
				return empresa;
		}
		return null;
	}
	
	public boolean removeEmpresaPorId(Integer id) {
		Iterator<Empresa> it = empresas.iterator();
		
		while (it.hasNext()) {
			Empresa empresa = it.next();
			if (empresa.getId()==id) {
				empresas.remove(empresa);
				return true;
			}
		}
		return false;
	}

}
