package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.UsuarioVo;


public class UsuarioDao {

	public Integer insertUsuario(UsuarioVo usu){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		Integer idUsuario = null;

		query.append("INSERT INTO TB_USUARIO (");
		query.append("NOME,");
		query.append("SOBRENOME,");
		query.append("DATA_NASCIMENTO,");
		query.append("SEXO,");
		query.append("CPF,");
		query.append("APELIDO,");
		query.append("EMAIL,");
		query.append("SENHA,");
		query.append("DATA_ENTRADA,");
		query.append("DATA_ULTIMA_MODIFICACAO,");
		query.append("ATIVO,");
		query.append("RECEBER_EMAIL,");
		query.append("ESPECIAL,");
		query.append("ID_PERFIL");
		query.append(")VALUES(");
		query.append("'"+usu.getNome()+"',");
		query.append("'"+usu.getSobrenome()+"',");
		query.append("'"+usu.getDataNascimento()+"',");
		query.append("'"+usu.getSexo()+"',");
		query.append("'"+usu.getCpf()+"',");
		query.append("'"+usu.getApelido()+"',");
		query.append("'"+usu.getEmail()+"',");
		query.append("'"+usu.getSenha()+"',");
		query.append("NOW(),");
		query.append("NOW(),");
		query.append("'"+usu.getAtivo()+"',");
		query.append("'"+usu.getReceberEmail()+"',");
		query.append("'"+usu.getEspecial()+"',");
		query.append(usu.getIdPerfil()+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				idUsuario = rset.getInt(1);
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return idUsuario;

	}

	public String getEmailExist(String email){
		
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();

		query.append("SELECT email FROM TB_USUARIO WHERE EMAIL LIKE('"+email+"')");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			if(rset.next()){
				return rset.getString("email");	
			}else{
				return null;
			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return null;
	}
}
