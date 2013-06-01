package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.TelefoneVo;

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
		query.append("ID_TIPO_TELEFONE");
		query.append(")VALUES(");
		query.append(tel.getDdd()+",");
		query.append(tel.getNumero()+",");
		query.append(tel.getIdUsuario()+",");
		query.append(tel.getIdTipoTelefone()+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}

	}

	public ArrayList<TelefoneVo> getTelefoneByUser(Integer id){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		TelefoneVo tel = new TelefoneVo();
		ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();

		query.append("SELECT ");
		query.append("	id,");
		query.append("	ddd,");
		query.append("	numero,");
		query.append("	id_usuario,");
		query.append("	id_tipo_telefone");
		query.append("	FROM tb_telefone");
		query.append("	WHERE id_usuario = "+id);
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			while(rset.next()){
				
				tel = new TelefoneVo();
				tel.setId(rset.getInt("id"));
				tel.setDdd(rset.getInt("ddd"));
				tel.setNumero(rset.getInt("numero"));
				tel.setIdUsuario(rset.getInt("id_usuario"));
				tel.setIdTipoTelefone(rset.getInt("id_tipo_telefone"));
				telAl.add(tel);
			}
			
		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getTelefoneByUser()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getTelefoneByUser()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return telAl;

	}

}
