package br.com.caelum.mvc;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class AdicionaContatosLogica implements logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {
	//	List <Contato> contatos = new ContatoDao().getLista();
	//	req.setAttribute("contatos", contatos);
		return "/WEB-INF/jsp/adiciona-contato.jsp";
	}
}