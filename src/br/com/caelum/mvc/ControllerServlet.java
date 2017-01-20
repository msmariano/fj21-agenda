package br.com.caelum.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	String parametro = request.getParameter("logica");
	String nomeDaClasse = "br.com.caelum.mvc." + parametro;
	try {
			Class<?> classe = Class.forName(nomeDaClasse);
			logica Logica = (logica) classe.newInstance();
			String pagina = Logica.executa(request, response);
			request.getRequestDispatcher(pagina).forward(request, response);
		} catch (Exception e) {
		throw new ServletException("A lógica de negócios causou uma exceção", e);
}
}
}