package br.com.caelum.mvc;

//Autor: Marcelo dos Santos Mariano - Estudo JavaEE
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class AlteraContatoLogica implements logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		req.setAttribute("contato", contato);
		ContatoDao dao = new ContatoDao();
		dao.seleciona(contato);
		System.out.println("Alterando contato... ");
		return "/WEB-INF/jsp/adiciona-contato.jsp";
		
	}
}