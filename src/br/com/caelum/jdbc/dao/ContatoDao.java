package br.com.caelum.jdbc.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao() {
		//this.connection = new ConnectionFactory().getConnection();
	}
	public void setConnection(Connection conn){
		this.connection = conn;
	}
	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
		"(nome,email,endereco,dataNascimento)" +
		" values (?,?,?,?)";
	    Date data = new Date(contato.getDataNascimento().getTimeInMillis());
		try {
		// prepared statement para inser��o
		java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
		
		// seta os valores
		stmt.setString(1,contato.getNome());
		stmt.setString(2,contato.getEmail());
		stmt.setString(3,contato.getEndereco());
		stmt.setDate(4,  data);
		
		// executa
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}		
	}      
	public List<Contato> getLista() {
	  try {
		    List<Contato> contatos = new ArrayList<Contato>();
	        java.sql.PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	          // criando o objeto Contato
			  Contato contato = new Contato();
			  contato.setId(rs.getLong("id"));
			  contato.setNome(rs.getString("nome"));
			  contato.setEmail(rs.getString("email"));
			  contato.setEndereco(rs.getString("endereco"));
	          // montando a data atrav�s do Calendar
	          Calendar data = Calendar.getInstance();
	          data.setTime(rs.getDate("dataNascimento"));
	          contato.setDataNascimento(data);
		      // adicionando o objeto � lista
	          contatos.add(contato);
	        }
	       rs.close();
	       stmt.close();
	       return contatos;
	      } catch (SQLException e) {
	          throw new RuntimeException(e);
	      }
	}
	public void seleciona(Contato contato) {
		String sql = "select * from contatos where id = ?";
		 try {
			    java.sql.PreparedStatement stmt = this.connection.prepareStatement(sql);
			   	stmt.setLong(1, contato.getId());
				ResultSet rs = stmt.executeQuery();
				rs.next();
				contato.setId(rs.getLong("id"));
			    contato.setNome(rs.getString("nome"));
			    contato.setEmail(rs.getString("email"));
			    contato.setEndereco(rs.getString("endereco"));
	            // montando a data atrav�s do Calendar
	            Calendar data = Calendar.getInstance();
	            data.setTime(rs.getDate("dataNascimento"));
	            contato.setDataNascimento(data);
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
		}
	}
	public void altera(Contato contato) {
	  String sql = "update contatos set nome=?, email=?,"+
	  "endereco=?, dataNascimento=? where id=?";
		
	  try {
	    PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco());
		stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
		stmt.setLong(5, contato.getId());
		stmt.execute();
		stmt.close();
		} catch (SQLException e) {
		throw new RuntimeException(e);
		}
	  }
	public void remove(Contato contato) {
	  String sql = "delete from contatos where id=?";
	  try {
	    PreparedStatement stmt = connection.prepareStatement(sql);
	    stmt.setLong(1, contato.getId());
	    stmt.execute();
	    stmt.close();
	  }catch(SQLException e) {
		  throw new RuntimeException();
	  }	  
	
	}
}
