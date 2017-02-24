package br.com.caelum.mvc;

import java.sql.Connection;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogica implements logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {
		Connection connection = null;
		connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = null;
		dao =  new ContatoDao();
		dao.setConnection(connection);
		List <Contato> contatos = dao.getLista();
		req.setAttribute("contatos", contatos);
		return "/WEB-INF/jsp/lista-contatos.jsp";
	}
}