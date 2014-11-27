package com.gymtraining.dao;

import com.gymtraining.beans.Usuario;
import com.gymtraining.data.DataBaseFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
	private Connection conexao; 
	private PreparedStatement stmt;

	public UsuarioDAO() throws Exception {
		conexao = DataBaseFactory.createConnectionToMySQL();
	}
	
	 public void insert(Usuario usuario) throws SQLException {  

		 //Define qual a consulta:
		 // Apesar de ter ID no objeto, ele não vai para o Banco, pois é AI
		 
		 String sql = "INSERT INTO tb_clientes "
		 		+ "(nome, email, data_nascimento, data_criacao, data_modificacao) "
		 		+ "values (?,?,?,?,?)";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, usuario.getNome());
		 stmt.setString(2, usuario.getEmail());
		 stmt.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
		 stmt.setDate(4, new java.sql.Date(usuario.getDataCriacao().getTime()));
		 stmt.setDate(5, new java.sql.Date(usuario.getDataModificacao().getTime()));

		 // Executa
		 stmt.executeUpdate();
		 stmt.close();
	}
	 
	 public void update(long id, Usuario usuario) throws SQLException {  

		 //Define qual a consulta:
		 String sql = "UPDATE tb_clientes SET"
		 		+ " nome = ?,"
		 		+ " email = ?,"
		 		+ " data_nascimento = ?,"
		 		+ " data_criacao = ?,"
		 		+ " data_modificacao = ?"
		 		+ " WHERE id = ?";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, usuario.getNome());
		 stmt.setString(2, usuario.getEmail());
		 stmt.setDate(3, new java.sql.Date(usuario.getDataNascimento().getTime()));
		 stmt.setDate(4, new java.sql.Date(usuario.getDataCriacao().getTime()));
		 stmt.setDate(5, new java.sql.Date(usuario.getDataModificacao().getTime()));
		 stmt.setString(6, Long.toString(id));

		 // Executa
		 stmt.executeUpdate();
		 stmt.close();
	}
	 
	 public void delete(long id) throws SQLException {  

		 //Define qual a consulta:
		 String sql = "DELETE FROM tb_clientes WHERE id = ?";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, Long.toString(id));

		 // Executa
		 stmt.executeUpdate();
		 stmt.close();
	}
	 
	 public Usuario selectById(long id) throws SQLException {  
		 Usuario user = new Usuario();
		 ResultSet result;

		 //Define qual a consulta:
		 String sql = "SELECT * FROM tb_clientes WHERE id = ?";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, Long.toString(id));

		 // Executa
		 result = stmt.executeQuery();
		 
		 // Montanto o Usuário: 
		 if (result.next()) {
			 user.setId(result.getLong("id"));
			 user.setNome(result.getString("nome"));
			 user.setEmail(result.getString("email"));
			 user.setDataNascimento(result.getDate("data_nascimento"));
			 user.setDataCriacao(result.getDate("data_criacao"));
			 user.setDataModificacao(result.getDate("data_modificacao"));
		 } else {
			 user = null;
		 }
		 
		 stmt.close();
		 
		 return user;
	}
	 
	public Usuario selectByMail(String email) throws SQLException {  
		 Usuario user = new Usuario();
		 ResultSet result;

		 //Define qual a consulta:
		 String sql = "SELECT * FROM tb_clientes WHERE email = ?";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, email);

		 // Executa
		 result = stmt.executeQuery();
		 
		 // Montanto o Usuário: 
		 if (result.next()) {
			 user.setId(result.getLong("id"));
			 user.setNome(result.getString("nome"));
			 user.setEmail(result.getString("email"));
			 user.setDataNascimento(result.getDate("data_nascimento"));
			 user.setDataCriacao(result.getDate("data_criacao"));
			 user.setDataModificacao(result.getDate("data_modificacao"));
		 } else {
			 user = null;
		 }
		 
		 stmt.close();
		 
		 return user;
	}
	 
	public String getNameById(long id) throws SQLException {  
		 String nome;
		 ResultSet result;

		 //Define qual a consulta:
		 String sql = "SELECT nome FROM tb_clientes WHERE id = ?";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, Long.toString(id));

		 // Executa
		 result = stmt.executeQuery();
		 
		 // Montanto o Usuário: 
		 if (result.next()) {
			 nome = result.getString("nome");
		 } else {
			 nome = null;
		 }
		 
		 stmt.close();
		 
		 return nome;
	}
	 
	public boolean isRegistered(String email) throws SQLException {  
		 String nome;
		 ResultSet result;

		 //Define qual a consulta:
		 String sql = "SELECT * FROM tb_clientes WHERE email = ?";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Preenche os valores
		 stmt.setString(1, email);

		 // Executa
		 result = stmt.executeQuery();
		 
		 // Retorna true se já tiver algum registro com esse e-mail
		 if (result.next()) {
			 stmt.close();
			 return true;
		 } else {
			 stmt.close();
			 return false;
		 }
	}
	 
	public List<Usuario> getAllNames() throws SQLException {  
		 List<Usuario> lista = new ArrayList<Usuario>();
		 ResultSet result;

		 //Define qual a consulta:
		 String sql = "SELECT id, nome FROM tb_clientes";
		 
		 // Statement:
		 stmt = conexao.prepareStatement(sql);

		 // Executa
		 result = stmt.executeQuery();
		 
		 // Montanto o Usuário: 
		 while (result.next()) {
			 Usuario user = new Usuario();
			 user.setId(result.getLong("id"));
			 user.setNome(result.getString("nome"));			 
			 
			 lista.add(user);
		 }
		 
		 stmt.close();
		 
		 return lista;
	}
}
