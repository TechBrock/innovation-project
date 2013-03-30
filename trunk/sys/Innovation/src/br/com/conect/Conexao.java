package br.com.conect;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {
	
	public static Connection open(Connection conn){
		return conn;
	}
	public static void close (ResultSet rset, Statement stm, Connection conn){
	}

}
