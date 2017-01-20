package br.com.caelum.mvc;

import java.text.SimpleDateFormat;
import java.util.Date;

//Autor: Marcelo dos Santos Mariano - Estudo JavaEE
//Teste de Commit para o GitHub 19012017 
//Teste de Commit para o GitHub 19012017 V1
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class AlteraContatoLogica implements logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		String sData;
		Contato contato = new Contato();
		contato.setId(id);
		ContatoDao dao = new ContatoDao();
		dao.seleciona(contato);			
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		sData = date.format(contato.getDataNascimento().getTime()).toString();
		req.setAttribute("contato", contato);
		req.setAttribute("sData", sData);
		System.out.println("Alterando contato... ");
		return "/WEB-INF/jsp/adiciona-contato.jsp";
		
	}
}