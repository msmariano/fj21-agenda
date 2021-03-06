


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<html> 

 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="js/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  function executar(acao){
	alert(acao);
	if (acao == 'alterar')
	{
		document.getElementById("cadastroUsuario").action = "alteraContato"
		document.getElementById("cadastroUsuario").submit();	
	}
	else
		document.getElementById("cadastroUsuario").submit();
  }
  
  </script>
  
<body>
<c:import url="cabecalho.jsp" />
<h1>Adiciona Contatos</h1>
<hr />
<form id = "cadastroUsuario" action="adicionaContato"   >
<input type="hidden" name = "idContato" value="${contato.id}" />
Nome: <input type="text" name="nome" value="${contato.nome}"  /><br />
E-mail: <input type="text" name="email" value="${contato.email}" /><br />
Endere�o: <input type="text" name="endereco" value="${contato.endereco}" /><br />
Data Nascimento: <caelum:campoData id="dataNascimento" value="${sData}" /> <br />
<input type="button" value="Gravar" onclick="executar('${acao}')"/>
</form>
<c:import url="rodape.jsp" />
</body>
</html>