package br.com.innovation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {
	
	public static Connection connect(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/metodo_metalurgica", "admin", "admin");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.Connection()");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.Connection()");
		}
		return null;
	}

	public static void disconnect(ResultSet rset, Statement stm, Connection conn){
		try{
			if(rset != null){
				rset.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.disconnect()");
		}
		try{
			stm.close();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.disconnect()");
		}

		try{
			conn.close();
		}catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.disconnect()");
		}
	}

}
