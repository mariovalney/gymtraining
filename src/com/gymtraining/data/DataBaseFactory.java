package com.gymtraining.data;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseFactory {
 
   // Dados do MYSQL
   private static final String USERNAME = "root";
   private static final String PASSWORD = "";
   private static final String DATABASE_NAME = "gymtraining";
 
   //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
   private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/" + DATABASE_NAME;
   
   // Criação da Conexão com Banco de Dados
   public static Connection createConnectionToMySQL() throws Exception{
      Class.forName("com.mysql.jdbc.Driver"); //Faz com que a classe seja carregada pela JVM
 
      //Cria a conexão com o banco de dados
      Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
 
      //Testa se a conexão falhou
      if(connection == null){
         System.out.println("Erro: Não foi possível conectar: " + connection);
      }
      
      return connection;
   }
}
