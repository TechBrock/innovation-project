package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.innovation.vo.EnderecoVo;

public class EnderecoDao {
	
	public void insertEndereco(EnderecoVo endVo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		
		query.append("INSERT INTO TB_ENDERECO(");
		query.append("CEP,");
		query.append("TIPO,");
		query.append("LOGRADOURO,");
		query.append("NUMERO,");
		query.append("COMPLEMENTO,");
		query.append("BAIRRO,");
		query.append("INFORMACOES_ADICIONAIS");
		query.append("ID_CIDADE");
		query.append("ID_USUARIO");
		
	}

}
