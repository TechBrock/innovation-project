package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.PrecoVo;

public class PrecoDao {
	public int insert(Double preco, Integer idModelo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		Integer countInsert = 0;

		query.append("INSERT INTO TB_PRECO(");
		query.append("id_modelo, ");
		query.append("valor");
		query.append(") values (");
		query.append(idModelo+",");
		query.append(preco+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				countInsert = rset.getInt(1);
			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insert()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insert()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;

	}

	public ArrayList<Double> getPrecoByModelo(Integer idModelo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		ArrayList<Double> precoAl = new ArrayList<Double>();

		query.append("select valor"); 
		query.append("	from tb_preco"); 
		query.append("	where id_modelo = "+idModelo); 
		query.append("	order by id desc"); 
		query.append("	limit 2 ");
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			while(rset.next()){
				precoAl.add(rset.getDouble("valor"));
			}
			
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPrecoByModelo()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPrecoByModelo()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return precoAl;

	}

}
