package br.com.innovation.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.ModeloVo;

public class ModeloDao {

	public int insertModelo(ModeloVo modelo){
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int idProduto = 0;

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
		query.append("	id_classificacao,"); 
		query.append("	id_cor,"); 
		query.append("	id_tipo,"); 
		query.append("	img_1,");
		query.append("	img_2,");
		query.append("	img_3,");
		query.append("	img_1) VALUES (");
		query.append("	'"+modelo.getNome()+"',");
		query.append(modelo.getQuantidade()+",");
		query.append(modelo.getTamanho()+",");
		query.append(modelo.getDimensao()+",");
		query.append(modelo.getPeso()+",");
		query.append(modelo.getAro()+",");
		query.append("'"+modelo.getInfAdc()+"',");
		query.append("'"+modelo.getGarantia()+"',");
		query.append("'"+modelo.getMaterial()+"',");
		query.append(modelo.getIdClassificacao()+",");
		query.append(modelo.getIdCor()+",");
		query.append(modelo.getIdTipo()+",");
		query.append(modelo.getImg1()+",");
		query.append(modelo.getImg2()+",");
		query.append(modelo.getImg3()+",");
		query.append(modelo.getImg4()+")");

		try{
			conn = Conexao.connect();
			conn.setAutoCommit(false);
			pstm = conn.prepareStatement(query.toString());

			if(rset.next()){
				idProduto = rset.getInt(1);
			}
		} catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertModelo()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, pstm, conn);

		}
		return idProduto;
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


	public ArrayList<ModeloVo> getModelo(ModeloVo modelo){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		ModeloVo modeloVo = new ModeloVo();
		ArrayList<ModeloVo> modeloAl = new ArrayList<ModeloVo>();

		query.append("SELECT ");
		query.append("	nome");
		query.append("	,quantidade"); 
		query.append("	,tamanho"); 
		query.append("	,dimensao"); 
		query.append("	,peso"); 
		query.append("	,aro"); 
		query.append("	,informacoes_adicionais");
		query.append("	,garantia");
		query.append("	,material"); 
		query.append("	,id_classificacao"); 
		query.append("	,id_cor"); 
		query.append("	,id_tipo");
		query.append(" FROM TB_MODELO");
		query.append(" WHERE 1=1");
		query.append(filtro);

		try{

			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){

				modeloVo = new ModeloVo();
				modeloVo.setNome(rset.getString("nome"));
				modelo.setQuantidade(rset.getInt("quantidade"));
				modelo.setTamanho(rset.getDouble("tamanho"));
				modelo.setDimensao(rset.getString("dimensão"));
				modelo.setPeso(rset.getDouble("peso"));
				modelo.setAro(rset.getInt("aro"));
				modelo.setInfAdc(rset.getString("informacoes_adicionais"));
				modelo.setGarantia(rset.getString("garantia"));
				modelo.setMaterial(rset.getString("material"));
				modelo.setIdClassificacao(rset.getInt("id_classificacao"));
				modelo.setIdCor(rset.getInt("id_cor"));
				modelo.setIdTipo(rset.getInt("id_tipo"));
				modeloAl.add(modeloVo);


			}
		} catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".getModelo()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

		}
		return modeloAl;
	}
}
