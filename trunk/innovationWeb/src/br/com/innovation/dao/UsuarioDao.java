package br.com.innovation.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.innovation.vo.TelefoneVo;
import br.com.innovation.vo.UsuarioVo;

import com.mysql.jdbc.Connection;

public class UsuarioDao {
	
	public Integer insertUsuario(UsuarioVo usu, ArrayList<TelefoneVo> telAl){
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
		query.append("ATIVO,");
		query.append("RECEBER_EMAIL,");
		query.append("ESPECIAL");
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
		query.append("'"+usu.getDataEntrada()+"',");
		query.append("'"+usu.getAtivo()+"',");
		query.append("'"+usu.getReceberEmail()+"',");
		query.append("'"+usu.getEspecial()+"',");
		query.append(usu.getIdPerfil()+")");
		
		try{
//			conn = Conexao.open();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();
			
			if(rset.next()){
				idUsuario = rset.getInt(1);
			}
			
			if(idUsuario != null && idUsuario > 0){
				for (TelefoneVo tel : telAl) {
					tel.setIdUsuario(idUsuario);
					new TelefoneDao().insertUsuario(tel);
				}
			}
			
			
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			sqlex.printStackTrace();
			
		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			e.printStackTrace();
			
		} finally {
//			Conexao.close(rset,stm,conn);
		}
		return idUsuario;

	}
}
