<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,
	br.com.caelum.jdbc.dao.*,
	br.com.caelum.modelo.*,
	java.text.SimpleDateFormat,
	java.util.Date;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<body>
		<table border ="2">
			<%
			ContatoDao dao = new ContatoDao();
			List<Contato> contatos = dao.getLista();
			for (Contato contato : contatos ) {
				SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
				String sData  = sdfData.format(contato.getDataNascimento().getTime()) ;
			%>
				<tr>
				<td><%=contato.getNome() %></td>
				<td><%=contato.getEmail() %></td>
				<td><%=contato.getEndereco() %></td>
				<td><%=sData%></td>
				</tr>
			<%
			}
			%>
		</table>
	</body>
</html>