package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.TipoProdutoVo;

public class TipoProdutoDao {

	public int insertTipoProduto(String nome){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countInsert = 0;

		query.append("INSERT INTO TB_TIPO_ITEM(nome) VALUES('"+nome+"')");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countInsert = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertTipoProduto()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertTipoProduto()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;

	}

	public int editTipoProduto(TipoProdutoVo tipoProdutoVo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countUpdate = 0;

		query.append("UPDATE TB_TIPO_ITEM SET nome = '"+tipoProdutoVo.getNome()+"'");
		query.append(" WHERE id = "+tipoProdutoVo.getId());

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

	public ArrayList<TipoProdutoVo> getTipoProduto (TipoProdutoVo tipoProdutoVo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		TipoProdutoVo tipo = new TipoProdutoVo();
		ArrayList<TipoProdutoVo> tipoProdutoAl = new ArrayList<TipoProdutoVo>();

		if(!tipoProdutoVo.getNome().equals(null) && !tipoProdutoVo.getNome().equals("")){
			filtro.append(" AND UPPER(nome) LIKE UPPER('%"+tipoProdutoVo.getNome()+"%')"); 
		}

		if(tipoProdutoVo.getId() != null && tipoProdutoVo.getId() > 0){
			filtro.append(" AND id = "+tipoProdutoVo.getId());
		}

		query.append("SELECT id");
		query.append(" ,nome");
		query.append(" FROM TB_TIPO_ITEM");
		query.append(" WHERE 1=1");
		query.append(filtro);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				tipo = new TipoProdutoVo();
				tipo.setId(rset.getInt("id"));
				tipo.setNome(rset.getString("nome"));
				tipoProdutoAl.add(tipo);
			}
		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getTipoProduto()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getTipoProduto()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return tipoProdutoAl;
	}

	public int deleteTipoProduto(int id){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countdelete = 0;

		query.append("DELETE FROM TB_TIPO_ITEM WHERE id = "+id);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countdelete = stm.executeUpdate(query.toString());

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deleteTipoProduto()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".deleteTipoProduto()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countdelete;
	}
	
	public java.util.List<SelectItem> getTipoProdutoSelect(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		java.util.List<SelectItem> tipoProdutoSelect= new ArrayList<SelectItem>(); 
		
		query.append("SELECT id,");
		query.append(" nome");
		query.append(" FROM TB_TIPO_ITEM");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				tipoProdutoSelect.add(new SelectItem(rset.getInt("id"), rset.getString("nome")));
			}

		}catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getTipoProdutoSelect()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getTipoProdutoSelect()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return tipoProdutoSelect;
	}

}

