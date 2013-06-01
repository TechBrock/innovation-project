package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.LoginVo;

public class LoginDao {
	
	public LoginVo getLogin(LoginVo login){
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		LoginVo loginVo  = new LoginVo();

		query.append("SELECT id");
		query.append(" ,id_perfil");
		query.append(" ,email");
		query.append(" ,senha");
		query.append(" ,apelido");
		query.append(" FROM TB_USUARIO");
		query.append(" WHERE UPPER(email) LIKE UPPER('"+login.getEmail()+"')");
		query.append(" AND UPPER(senha) LIKE UPPER('"+login.getSenha()+"')");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			if(rset.next()){
				loginVo.setId(rset.getInt("id"));
				loginVo.setIdPerfil(rset.getInt("id_perfil"));
				loginVo.setEmail(rset.getString("email"));
				loginVo.setSenha(rset.getString("senha"));
				loginVo.setApelido(rset.getString("apelido"));

			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getLogin()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getLogin()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return loginVo;
	}

}
