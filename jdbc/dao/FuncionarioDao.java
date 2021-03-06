package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Funcionario;

public class FuncionarioDao {
	private Connection connection;
	
	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection(); 
	}
	
	public void adiciona(Funcionario funcionario) {
		String sql = "insert into funcionario (nome,usuario,senha)values(?,?,?)";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e)
		{
			throw new RuntimeException();
		}	
		
	}
	public List<Funcionario> getLista() throws SQLException {
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		String sql = "select * from funcionario";
		PreparedStatement stmt = connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		while(rs.next()) {
			Funcionario funcionario = new Funcionario();
			funcionario.setId(rs.getLong("id"));
			funcionario.setNome(rs.getString("nome"));
			funcionario.setUsuario(rs.getString("usuario"));
			funcionario.setSenha(rs.getString("senha"));
			funcionarios.add(funcionario);
		}	
		
		return funcionarios;
		
	}
	public void modifica(Funcionario funcionario) {
		String sql = "update funcionario set nome = ?,usuario = ?,senha = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			stmt.execute();
			stmt.close();			
			
		} catch (SQLException e) {
			
			throw new RuntimeException();
		}
		
	}
	public void remove(Funcionario funcionario) {
		String sql = "delete from funcionario where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
		    stmt.setLong(1, funcionario.getId());
			stmt.execute();
			stmt.close();			
			
		} catch (SQLException e) {
			
			throw new RuntimeException();
		}
	}

	
	

}
