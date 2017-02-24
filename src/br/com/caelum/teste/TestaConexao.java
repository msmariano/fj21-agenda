package br.com.caelum.teste;


import java.util.Date;
import java.util.List;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.dao.FuncionarioDao;
import br.com.caelum.modelo.Contato;
import br.com.caelum.modelo.Funcionario;

public class TestaConexao {
	
	 public static void main(String args[]) throws SQLException  {		
		 		 
		 Calendar cal = Calendar.getInstance();
		 Date parsed = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		 
		 try {
		    parsed = format.parse("19700304");
		 } catch (ParseException e1) {		   
		   e1.printStackTrace();
		 }
		 
		 cal.setTime(parsed);
		 // pronto para gravar
		 Contato contato = new Contato();
		 contato.setNome("Marcelo dos Santos Mariano");
		 contato.setEmail("marcelodossantosmariano@gmail.com");
		 contato.setEndereco("R. Cyro Vellozo nº56");
		 contato.setId(3L);
		 contato.setDataNascimento(cal);
	
		 // grave nessa conexão!!!
		 ContatoDao dao = new ContatoDao();
		 dao.remove(contato);
		 Funcionario funcionario = new Funcionario();
		 funcionario.setNome("Maria");
		 funcionario.setUsuario("maria");
		 funcionario.setSenha("qwerty");
		 FuncionarioDao funcDao = new FuncionarioDao();
		 funcDao.adiciona(funcionario);
		//dao.altera(contato);
		 // método elegante
		 //dao.adiciona(contato);
		 //System.out.println("Gravado!");
		 List <Contato> contatos = dao.getLista();
		 for (Contato contatoView : contatos) {
			 System.out.println("Nome: " + contatoView.getNome());
			 System.out.println("Email: " + contatoView.getEmail());
			 System.out.println("Endereço: " + contatoView.getEndereco());
			 System.out.println("Data de Nascimento: " +
			 contatoView.getDataNascimento().getTime() + "\n");
		 }
		 
		 List <Funcionario> funcionarios = funcDao.getLista();
		 for (Funcionario funcView : funcionarios) {
			 System.out.println("Nome: "+ funcView.getNome());
			 System.out.println("Usuario: "+ funcView.getUsuario());
			 System.out.println("Senha: "+ funcView.getSenha());
			 System.out.println("\n");
			 
		 }
		 
		 
		 
		 
	 }

}
