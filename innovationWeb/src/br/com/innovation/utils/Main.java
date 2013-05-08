package br.com.innovation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/innovation", "admin", "admin");
			System.out.println("Conectou");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.Connection()");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRO: br.com.innovation.utils.Connection()");
		}
		
	}
	
}

