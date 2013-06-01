package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.ClassificacaoVo;

public class ClassificacaoDao {


	public int insertClass(String classificacao){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countInsert = 0;

		query.append("INSERT INTO TB_CLASSIFICACAO(NOME) VALUES('"+classificacao+"')");

		try{

			conn = Conexao.connect();
			stm = conn.createStatement();
			countInsert = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertClass()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertClass()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;
	}

	public int edtitClass(ClassificacaoVo classVo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countUpdate = 0;

		query.append("UPDATE TB_CLASSIFICACAO SET nome = '"+classVo.getNome()+"' WHERE id = "+classVo.getId());

		try{

			conn = Conexao.connect();
			stm = conn.createStatement();
			countUpdate = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".edtitClass()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".edtitClass()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countUpdate;
	}

	public int deleteClas(int id){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countdelete = 0;

		query.append("DELETE FROM TB_CLASSIFICACAO WHERE id = "+id);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countdelete = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deleteClas()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deleteClas()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countdelete;
	}

	public ArrayList<ClassificacaoVo> getClass (ClassificacaoVo classVo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		ClassificacaoVo classi = new ClassificacaoVo();
		ArrayList<ClassificacaoVo> classAl = new ArrayList<ClassificacaoVo>();

		if(classVo.getNome() != null && !classVo.getNome().equals("")){
			filtro.append(" AND UPPER(nome) LIKE UPPER('%"+classVo.getNome()+"%')"); 
		}

		if(classVo.getId() != null && classVo.getId() > 0){
			filtro.append(" AND id = "+classVo.getId());
		}

		query.append("SELECT id");
		query.append(" ,nome");
		query.append(" FROM TB_CLASSIFICACAO");
		query.append(" WHERE 1=1");
		query.append(filtro);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				classi = new ClassificacaoVo();
				classi.setId(rset.getInt("id"));
				classi.setNome(rset.getString("nome"));
				classAl.add(classi);
			}
		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getClass()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getClass()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return classAl;
	}
	public java.util.List<SelectItem> getClassificacaoSelect(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		java.util.List<SelectItem> classSelect= new ArrayList<SelectItem>(); 

		query.append("SELECT id,");
		query.append(" nome");
		query.append(" FROM TB_CLASSIFICACAO");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				classSelect.add(new SelectItem(rset.getInt("id"), rset.getString("nome")));
			}

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getClassificacaoSelect()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getClassificacaoSelect()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return classSelect;
	}

}


