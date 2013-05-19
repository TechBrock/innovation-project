package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.FavoritoVo;

public class FavoritoDao {

	public int insert(FavoritoVo fav){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int count = 0;

		query.append("INSERT INTO tb_favorito(");
		query.append("id_modelo,");
		query.append("id_usuario");
		query.append(")VALUES(");
		query.append(fav.getIdModelo()+",");
		query.append(fav.getIdUsuario()+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			count = stm.executeUpdate(query.toString());
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insert()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insert()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return count;
	}

	public int delete(Integer id){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int count = 0;

		query.append("DELETE FROM tb_favorito WHERE id ="+id);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			count = stm.executeUpdate(query.toString());

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".delete()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".delete()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return count;
	}

	public ArrayList<FavoritoVo> getFavoriteByUser(Integer idUser){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		FavoritoVo favoritoVo = new FavoritoVo();
		ArrayList<FavoritoVo> favoritoAl = new ArrayList<FavoritoVo>();

		query.append("SELECT"); 
		query.append("	f.id as id_fav");
		query.append("	,f.id_usuario as id_user");
		query.append("	,f.id_modelo as id_mod");
		query.append("	,m.nome as nome_modelo");
		query.append("	,m.img_1 as img1_modelo");
		query.append("	,c.nome as nome_cor");
		query.append("	,cla.nome as nome_class");
		query.append("	,pre.valor as preco");
		query.append("	FROM tb_favorito f"); 
		query.append("	INNER JOIN tb_modelo m ON f.id_modelo = m.id"); 
		query.append("	INNER JOIN tb_preco pre ON pre.id_modelo = m.id");
		query.append("	INNER JOIN tb_cor c ON m.id_cor = c.id");
		query.append("	INNER JOIN tb_classificacao cla ON m.id_classificacao = cla.id");
		query.append("	WHERE f.id_usuario = "+idUser);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){

				favoritoVo = new FavoritoVo();
				favoritoVo.setId(rset.getInt("id_fav"));
				favoritoVo.setIdUsuario(rset.getInt("id_user"));
				favoritoVo.setIdModelo(rset.getInt("id_mod"));
				favoritoVo.setNomeModelo(rset.getString("nome_modelo"));
				favoritoVo.setNomeCor(rset.getString("nome_cor"));
				favoritoVo.setNomeClassificacao(rset.getString("nome_class"));
				favoritoVo.setPreco(rset.getDouble("preco"));
				favoritoAl.add(favoritoVo);

			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getFavoriteByUser()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getFavoriteByUser()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return favoritoAl;

	}

	public int getCountFavorites(Integer idUser){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countFav = 0;

		query.append("SELECT COUNT(ID) as id_count"); 
		query.append("	FROM tb_favorito ");
		query.append("	WHERE id_usuario = "+idUser);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			if(rset.next()){
				countFav = rset.getInt("id_count");
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCountFavorites()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCountFavorites()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countFav;

	}

	public int getExist(Integer idUsuario, Integer idModelo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int id = 0;

		query.append("SELECT id");
		query.append("	FROM tb_favorito");
		query.append("	WHERE id_usuario = idUsuario"); 
		query.append("	AND id_modelo = idModelo;");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				id = rset.getInt("id");
			}
			
			
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getExist()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getExist()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return id;

	}


}
