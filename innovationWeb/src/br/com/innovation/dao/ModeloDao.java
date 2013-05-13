package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.ModeloVo;

public class ModeloDao {

	public int insertModelo(ModeloVo modelo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int idModelo= 0;

		query.append("INSERT INTO TB_MODELO(");
		query.append("	nome, ");
		query.append("	quantidade,"); 
		query.append("	tamanho,"); 
		query.append("	dimensao,"); 
		query.append("	peso,"); 
		query.append("	aro,"); 
		query.append("	informacoes_adicionais,");
		query.append("	garantia, ");
		query.append("	material,");
		query.append("	caracteristicas,"); 
		query.append("	id_classificacao,"); 
		query.append("	id_cor,"); 
		query.append("	id_tipo)VALUES ("); 
		query.append("'"+modelo.getNome()+"',");
		query.append(modelo.getQuantidade()+","); 
		query.append(modelo.getTamanho()+","); 
		query.append("'"+modelo.getDimensao()+"',"); 
		query.append(modelo.getPeso()+","); 
		query.append(modelo.getAro()+","); 
		query.append("'"+modelo.getInfAdc()+"',");
		query.append(+modelo.getGarantia()+",");
		query.append("'"+modelo.getMaterial()+"',");
		query.append("'"+modelo.getCaract()+"',"); 
		query.append("'"+modelo.getIdClassificacao()+"',"); 
		query.append(modelo.getIdCor()+",");
		query.append(modelo.getIdTipo()+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				idModelo = rset.getInt(1);
			}


		} catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertModelo()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

		}
		return idModelo;
	}

	public void updateImage(ArrayList<String> caminhoImg, Integer id){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();

		query.append("UPDATE TB_MODELO SET ");
		query.append("IMG_1 = "+caminhoImg.get(0));
		if(caminhoImg.get(1)!= null || caminhoImg.get(1).equals("")){
			query.append(",IMG_2 = "+caminhoImg.get(1));
		}
		if(caminhoImg.get(2)!= null || caminhoImg.get(1).equals("")){
			query.append(",IMG_3 = "+caminhoImg.get(2));
		}
		if(caminhoImg.get(3)!= null || caminhoImg.get(3).equals("")){
			query.append(",IMG_4 = "+caminhoImg.get(3));
		}
		query.append(" 	WHERE ID = "+id);



		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString());

		} catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".updateImage()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

		}

	}

	public int updateModelo( ModeloVo modelo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int idProduto = 0;

		query.append("UPDATE TB_MODELO SET");
		query.append("	nome = '"+modelo.getNome()+"',");
		query.append("	quantidade = "+modelo.getQuantidade()+","); 
		query.append("	tamanho = "+modelo.getTamanho()+","); 
		query.append("	dimensao = '"+modelo.getDimensao()+"',"); 
		query.append("	peso = "+modelo.getPeso()+","); 
		query.append("	aro = "+modelo.getAro()+","); 
		query.append("	informacoes_adicionais = '"+modelo.getInfAdc()+"',");
		query.append("	garantia = '"+modelo.getGarantia()+"',");
		query.append("	material = '"+modelo.getMaterial()+"',"); 
		query.append("	id_classificacao = "+modelo.getIdClassificacao()+","); 
		query.append("	id_cor = "+modelo.getIdCor()+","); 
		query.append("	id_tipo ="+modelo.getIdTipo()); 

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString());
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				idProduto = rset.getInt(1);
			}
		} catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".updateModelo()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

		}
		return idProduto;
	}

	public ArrayList<ModeloVo> getModeloAll(){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		ModeloVo modeloVo = new ModeloVo();
		ArrayList<ModeloVo> modeloAl = new ArrayList<ModeloVo>();

		query.append("SELECT id,");
		query.append("nome,");
		query.append("caracteristicas,");
		query.append("quantidade,");
		query.append("tamanho,");
		query.append("dimensao,");
		query.append("peso,");
		query.append("aro,");
		query.append("informacoes_adicionais,");
		query.append("garantia,");
		query.append("material,");
		query.append("id_classificacao,");
		query.append("id_tipo,");
		query.append("id_cor,");
		query.append("img_1,");
		query.append("img_2,");
		query.append("img_3,");
		query.append("img_4"); 
		query.append(" FROM TB_MODELO");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				modeloVo = new ModeloVo();

				modeloVo.setId(rset.getInt("id"));
				modeloVo.setNome(rset.getString("nome"));
				modeloVo.setCaract(rset.getString("caracteristicas"));
				modeloVo.setQuantidade(rset.getInt("quantidade"));
				modeloVo.setTamanho(rset.getDouble("tamanho"));
				modeloVo.setDimensao(rset.getString("dimensao"));
				modeloVo.setPeso(rset.getDouble("peso"));
				modeloVo.setAro(rset.getInt("aro"));
				modeloVo.setInfAdc(rset.getString("informacoes_adicionais"));
				modeloVo.setGarantia(rset.getDouble("garantia"));
				modeloVo.setMaterial(rset.getString("material"));
				modeloVo.setIdClassificacao(rset.getInt("id_classificacao"));
				modeloVo.setIdTipo(rset.getInt("id_tipo"));
				modeloVo.setIdCor(rset.getInt("id_cor"));
				modeloVo.setImg1Caminho(rset.getString("img_1"));
				modeloVo.setImg2Caminho(rset.getString("img_2"));
				modeloVo.setImg3Caminho(rset.getString("img_3"));
				modeloVo.setImg4Caminho(rset.getString("img_4"));
				modeloAl.add(modeloVo);
			}
		}catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".updateModelo()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

		}
		return modeloAl;
	}

	public ArrayList<ModeloVo> getModeloPesq(ModeloVo modelo){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder query2 = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		ModeloVo modeloVo = new ModeloVo();
		ArrayList<ModeloVo> modeloAl = new ArrayList<ModeloVo>();

		if(modelo.getId() != null && modelo.getId() > 0){
			filtro.append(" AND id = "+modelo.getId());
		}

		if(modelo.getNome() != null && !modelo.getNome().equals("")){
			filtro.append(" AND UPPER nome LIKE UPPER (%'"+modelo.getNome()+"'%)");
		}


		query.append("select ");
		query.append("id,");
		query.append("nome,");
		query.append("caracteristicas,"); 
		query.append("quantidade, ");
		query.append("tamanho,");
		query.append("dimensao,");
		query.append("peso,");
		query.append("aro,");
		query.append("informacoes_adicionais,");
		query.append("garantia,");
		query.append("material, ");
		query.append("id_classificacao,");
		query.append("id_tipo,");
		query.append("id_cor,");
		query.append("img_1,");
		query.append("img_2,");
		query.append("img_3,");
		query.append("img_4");
		query.append("	FROM TB_MODELO");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){

				modeloVo = new ModeloVo();
				modeloVo.setId(rset.getInt("id"));
				modeloVo.setNome(rset.getString("nome"));
				modeloVo.setCaract(rset.getString("caracteristicas")); 
				modeloVo.setQuantidade(rset.getInt("quantidade"));
				modeloVo.setTamanho(rset.getDouble("tamanho"));
				modeloVo.setDimensao(rset.getString("dimensao"));
				modeloVo.setPeso(rset.getDouble("peso"));
				modeloVo.setAro(rset.getInt("aro"));
				modeloVo.setInfAdc(rset.getString("informacoes_adicionais"));
				modeloVo.setGarantia(rset.getDouble("garantia"));
				modeloVo.setMaterial(rset.getString("material"));
				modeloVo.setIdClassificacao(rset.getInt("id_classificacao"));
				modeloVo.setIdTipo(rset.getInt("id_tipo"));
				modeloVo.setIdCor(rset.getInt("id_cor"));
				modeloVo.setImg1Caminho(rset.getString("img_1"));
				modeloVo.setImg2Caminho(rset.getString("img_2"));
				modeloVo.setImg3Caminho(rset.getString("img_3"));
				modeloVo.setImg4Caminho(rset.getString("img_4"));
				modeloAl.add(modeloVo);
			}
			
			rset = null;
			for (ModeloVo mod : modeloAl) {
				query2 = new StringBuilder();
				query2.append("SELECT valor");
				query2.append("	FROM tb_preco");
				query2.append("	WHERE id_modelo = "+mod.getId());
				query2.append("	ORDER BY id DESC limit 1");
				
				rset = stm.executeQuery(query2.toString());
				while(rset.next()){
					mod.setPrecoAtual(rset.getDouble("valor"));
				}
			}
			
			
		}catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".getModeloPesq()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

		}
		return modeloAl;
	}
}


