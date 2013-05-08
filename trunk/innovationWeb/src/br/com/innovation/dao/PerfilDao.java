package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.PerfilVo;

public class PerfilDao {

	public int insertPerfil(String descricao){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countInsert = 0;

		query.append("INSERT INTO TB_PERFIL(descricao) VALUES('"+descricao+"')");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countInsert = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertPerfil()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertPerfil()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;

	}

	public int editPerfil(PerfilVo perfilVo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countUpdate = 0;

		query.append("UPDATE TB_PERFIL SET descricao = '"+perfilVo.getDescricao()+"'");
		query.append(" WHERE id = "+perfilVo.getId());

		try{

			conn = Conexao.connect();
			stm = conn.createStatement();
			countUpdate = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".editPerfil()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".editPerfil()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countUpdate;
	}

	public ArrayList<PerfilVo> getPerfil(PerfilVo perfilVo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		PerfilVo perfil = new PerfilVo();
		ArrayList<PerfilVo> perfilAl = new ArrayList<PerfilVo>();

		if(!perfilVo.getDescricao().equals(null) && !perfilVo.getDescricao().equals("")){
			filtro.append(" AND UPPER(descricao) LIKE UPPER('%"+perfilVo.getDescricao()+"%')"); 
		}

		if(perfilVo.getId() != null && perfilVo.getId() > 0){
			filtro.append(" AND id = "+perfilVo.getId());
		}

		query.append("SELECT id");
		query.append(" ,descricao");
		query.append(" FROM TB_PERFIL");
		query.append(" WHERE 1=1");
		query.append(filtro);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				perfil = new PerfilVo();
				perfil.setId(rset.getInt("id"));
				perfil.setDescricao(rset.getString("descricao"));
				perfilAl.add(perfil);
			}
		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPerfil()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPerfil()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return perfilAl;
	}

	public int deletePerfil(int id){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countdelete = 0;

		query.append("DELETE FROM TB_PERFIL WHERE id = "+id);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countdelete = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deletePerfil()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deletePerfil()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countdelete;
	}

	public java.util.List<SelectItem> getPerfilSelect(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();

		java.util.List<SelectItem> perfilSelect= new ArrayList<SelectItem>(); 
		query.append("SELECT id,");
		query.append(" descricao");
		query.append(" FROM TB_PERFIL");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				perfilSelect.add(new SelectItem(rset.getInt("id"), rset.getString("descricao")));
			}

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPerfilSelect()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPerfilSelect()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return perfilSelect;
	}
}