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
		query.append(modelo.getIdTipo()+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				idProduto = rset.getInt(1);
			}
		} catch (SQLException sqlex) {

			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertModelo()");
			sqlex.printStackTrace();

		}finally{

			Conexao.disconnect(rset, stm, conn);

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
	
	
	public ModeloVo getModelo(ModeloVo modelo){
	
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		ArrayList<ModeloVo> modeloVo = new ArrayList<ModeloVo>();
		
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
		
		conn = Conexao.connect();
		stm = conn.createStatement();
		stm.executeUpdate(query.toString());
		rset = stm.getGeneratedKeys();
		
		
	
	
	}
	
	}

}
