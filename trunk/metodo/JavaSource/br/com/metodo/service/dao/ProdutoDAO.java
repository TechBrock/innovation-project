package br.com.metodo.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.metodo.service.vo.ProdutoVo;
import br.com.metodo.util.Conexao;

public class ProdutoDAO {

	public ProdutoVo consultarEstoque(int id){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		ProdutoVo produtoRetorno = new ProdutoVo();

		query.append("SELECT QUANTIDADE FROM tb_md_produto WHERE ID_WEB=");
		query.append(""+id+";");
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			if(rset.next()){
				produtoRetorno = new ProdutoVo();
				produtoRetorno.setIdWeb(id);
				produtoRetorno.setQuantidade(rset.getInt(1));
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return produtoRetorno;

	}
	
	public String consultarEstoqueString(int id){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		String produtoRetorno = null;

		query.append("SELECT QUANTIDADE FROM tb_md_produto WHERE ID_WEB=");
		query.append(""+id+";");
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			if(rset.next()){
				produtoRetorno = String.valueOf(rset.getInt(1));
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return produtoRetorno;

	}
	
}
