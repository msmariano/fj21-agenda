package br.com.caelum.mvc;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogica implements logica {
	public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {
		long id = Long.parseLong(req.getParameter("id"));
		Contato contato = new Contato();
		contato.setId(id);
		Connection connection = null;
		connection = (Connection) req.getAttribute("conexao");
		ContatoDao dao = new ContatoDao();
		dao.setConnection(connection);
		dao.remove(contato);
		System.out.println("Excluindo contato... ");
		return "mvc?logica=ListaContatosLogica";
	}
}