package br.com.innovation.dao;

import java.sql.ResultSet;
import java.sql.Statement;

import br.com.innovation.vo.TelefoneVo;

import com.mysql.jdbc.Connection;

public class TelefoneDao {
	
	public void insertUsuario(TelefoneVo tel){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO TB_TELEFONE(");
		query.append("DDD,");
		query.append("NUMERO,");
		query.append("ID_USUARIO,");
		query.append("ID_TIPO_TEL");
		query.append(")VALUES(");
		query.append(tel.getDdd()+",");
		query.append(tel.getNumero()+",");
		query.append(tel.getIdUsuario()+",");
		query.append(tel.getIdTipoTelefone()+")");
		
		
	}

}
