package com.gymtraining.dao;

import com.gymtraining.beans.Exercicio;
import com.gymtraining.data.DataBaseFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExercicioDAO {
    private Connection conexao; 
    private PreparedStatement stmt;

    public ExercicioDAO() throws Exception {
        conexao = DataBaseFactory.createConnectionToMySQL();
    }
    
	public void insert(Exercicio exercicio) throws SQLException {  

         //Define qual a consulta:
         String sql = "INSERT INTO tb_exercicios "
                + "(nome, descricao, id_cliente) "
                + "values (?,?,?)";
         
         // Statement:
         stmt = conexao.prepareStatement(sql);

         // Preenche os valores
         stmt.setString(1, exercicio.getNome());
         stmt.setString(2, exercicio.getDescricao());
         stmt.setString(3, Long.toString(exercicio.getId_cliente()));

         // Executa
         stmt.executeUpdate();
         stmt.close();
         conexao.close();
    }
     
     public void update(long id, Exercicio exercicio) throws SQLException {  

         //Define qual a consulta:
         String sql = "UPDATE tb_exercicios SET"
                + " nome = ?,"
                + " descricao = ?,"
                + " id_cliente = ?"
                + " WHERE id = ?";
         
         // Statement:
         stmt = conexao.prepareStatement(sql);

         // Preenche os valores
         stmt.setString(1, exercicio.getNome());
         stmt.setString(2, exercicio.getDescricao());
         stmt.setString(3, Long.toString(exercicio.getId_cliente()));
         stmt.setString(4, Long.toString(id));

         // Executa
         stmt.executeUpdate();
         stmt.close();
         conexao.close();
    }
     
     public void delete(long id) throws SQLException {  

         //Define qual a consulta:
         String sql = "DELETE FROM tb_exercicios WHERE id = ?";
         
         // Statement:
         stmt = conexao.prepareStatement(sql);

         // Preenche os valores
         stmt.setString(1, Long.toString(id));

         // Executa
         stmt.executeUpdate();
         stmt.close();
         conexao.close();
    }
     
     public Exercicio selectById(long id) throws SQLException {  
         Exercicio exec = new Exercicio();
         ResultSet result;

         //Define qual a consulta:
         String sql = "SELECT * FROM tb_exercicios WHERE id = ?";
         
         // Statement:
         stmt = conexao.prepareStatement(sql);

         // Preenche os valores
         stmt.setString(1, Long.toString(id));

         // Executa
         result = stmt.executeQuery();
         
         // Montanto o Usuário: 
         if (result.next()) {
             exec.setId(result.getLong("id"));
             exec.setNome(result.getString("nome"));
             exec.setDescricao(result.getString("descricao"));
             exec.setId_cliente(result.getLong("id_cliente"));
         } else {
        	 exec = null;
         }
         
         stmt.close();
         conexao.close();
        
         return exec;
    }
     
     public List<Exercicio> selectByIdCliente(long id) throws SQLException {  
    	 
    	 List<Exercicio> cursor = new ArrayList<Exercicio>();
         ResultSet result;

         //Define qual a consulta:
         String sql = "SELECT * FROM tb_exercicios WHERE id_cliente = ?";
         
         // Statement:
         stmt = conexao.prepareStatement(sql);

         // Preenche os valores
         stmt.setString(1, Long.toString(id));

         // Executa
         result = stmt.executeQuery();
         
         // Montanto o Usuário: 
         while (result.next()) {
        	 Exercicio exec = new Exercicio();
        	 
             exec.setId(result.getLong("id"));
             exec.setNome(result.getString("nome"));
             exec.setDescricao(result.getString("descricao"));
             exec.setId_cliente(result.getLong("id_cliente"));
             
             cursor.add(exec);
         }
         
         stmt.close();
         conexao.close();
        
         return cursor;
    }
}
