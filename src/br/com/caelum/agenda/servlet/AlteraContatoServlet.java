package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import antlr.Parser;
import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet("/adicionaContato")
public class AlteraContatoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int contador = 0;

	protected void service(HttpServletRequest request,HttpServletResponse response)throws IOException, ServletException {
		// busca o writer
		contador++;
		PrintWriter out = response.getWriter();
		// buscando os par�metros no request
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		String idContato = request.getParameter("idContato");
		Calendar dataNascimento = null;
		// fazendo a convers�o da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de convers�o da data");
			return; //para a execu��o do m�todo
		}
		// monta um objeto contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		contato.setId(Long.parseLong(idContato));
		
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		// imprime o nome do contato que foi adicionado
		/*out.println("<html>");
		out.println("<body>");
		out.println("Contador agora �: " + contador);
		out.println("Contato " + contato.getNome() +
				" adicionado com sucesso");
		out.println("</body>");
		out.println("</html>");*/
		RequestDispatcher rd = request.getRequestDispatcher("/mvc?logica=ListaContatosLogica");
		rd.forward(request,response);
		}
	}
