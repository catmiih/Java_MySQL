package main;

import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {
	public static void main(String[] args) {
		
		Connection connect = null;
		
		try {
			
			/* Tentativa de conexão com o banco */
		    connect = DriverManager.getConnection("jdbc:mysql://localhost/javamysql?" + 
		    							"user=root&password=");
		    
		    System.out.println("Conexão realizada com sucesso.");
		    
		    /* Criação de comandos SQL */
		    String query = "SELECT datahora from dadosHora;"; //Criação da query
		    Statement exec = connect.prepareStatement(query); //Execução da query
		    ResultSet result = exec.executeQuery(query); //Resultado da query
		    
		    while(result.next()) { //Enquanto houver linhas no retorno
		    	System.out.println(result.getString("dataHora")); //Imprime resultado["campo"]
		    }
		    
		    
		    
		} catch (SQLException ex) {
		    System.out.println("SQL Exception: " + ex.getMessage());
		    System.out.println("Código do erro: " + ex.getErrorCode());
		}
	}
}
