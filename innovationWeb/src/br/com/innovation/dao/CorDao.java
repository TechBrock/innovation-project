package br.com.innovation.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.CorVo;

public class CorDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 569504289612697935L;
	
	public int insertCor(String cor){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countInsert = 0;
		
		query.append("INSERT INTO TB_COR(NOME) VALUES('"+cor+"')");
		
		try{
			
			conn = Conexao.connect();
			stm = conn.createStatement();
			countInsert = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertCor()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertCor()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;
	}
	
	public int edtitCor(CorVo corVo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countUpdate = 0;
		
		query.append("UPDATE TB_COR SET nome = '"+corVo.getNome()+"' WHERE id = "+corVo.getId());
		
		try{

			conn = Conexao.connect();
			stm = conn.createStatement();
			countUpdate = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".editTipoProduto()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".editTipoProduto()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countUpdate;
	}
	
	public int deleteCor(int id){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countdelete = 0;

		query.append("DELETE FROM TB_COR WHERE id = "+id);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countdelete = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deleteCor()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deleteCor()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countdelete;
	}

	public ArrayList<CorVo> getCor (CorVo corVo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		CorVo cor = new CorVo();
		ArrayList<CorVo> corAl = new ArrayList<CorVo>();

		if(corVo.getNome() != null && !corVo.getNome().equals("")){
			filtro.append(" AND UPPER(nome) LIKE UPPER('%"+corVo.getNome()+"%')"); 
		}

		if(corVo.getId() != null && corVo.getId() > 0){
			filtro.append(" AND id = "+corVo.getId());
		}

		query.append("SELECT id");
		query.append(" ,nome");
		query.append(" FROM TB_COR");
		query.append(" WHERE 1=1");
		query.append(filtro);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				corVo = new CorVo();
				cor.setId(rset.getInt("id"));
				cor.setNome(rset.getString("nome"));
				corAl.add(cor);
			}
		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCor()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCor()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return corAl;
	}
	
	public java.util.List<SelectItem> getCorSelect(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		java.util.List<SelectItem> corSelect= new ArrayList<SelectItem>(); 

		query.append("SELECT id,");
		query.append(" nome");
		query.append(" FROM TB_COR");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				corSelect.add(new SelectItem(rset.getInt("id"), rset.getString("nome")));
			}

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCorSelect()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCorSelect()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return corSelect;
	}

}
