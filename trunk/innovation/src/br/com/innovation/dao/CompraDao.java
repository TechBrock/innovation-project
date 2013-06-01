package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.CompraVo;

public class CompraDao {

	public int insertCompra( CompraVo compra){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countInsert = 0;
		
		DateFormat frm = new SimpleDateFormat("yyyy-MM-dd");
		long dataNew;
		dataNew = new Date().getTime()+864000000;
		System.out.println(frm.format(new Date(dataNew)));

		query.append("	INSERT INTO tb_compra (ordem_compra");
		query.append(",	qtd_parcelas");
		query.append(", desconto");
		query.append(", valor_frete");
		query.append(", valor_compra");
		query.append(", prazo");
		query.append(", aprovado");
		query.append(", data_pedido");
		query.append(", data_entrega");
		query.append(", id_juros");
		query.append(", id_endereco_entrega");
		query.append(", id_usuario");
		query.append(", id_meio_pagamento");
		query.append(", id_tipo_frete)");
		query.append("VALUES(");
		query.append(compra.getOrdemCompra()+",");
		query.append(compra.getQtdParcelas()+",");
		query.append(compra.getDesconto()+",");
		query.append(compra.getValorFrete()+",");
		query.append(compra.getValorCompra()+",");
		query.append(compra.getPrazo()+",");
		query.append("'"+compra.getAprovado()+"',");
		query.append("now(),");
		query.append("'"+frm.format(dataNew)+"',");
		query.append(compra.getIdJuros()+",");
		query.append(compra.getIdEnderecoEntrega()+",");
		query.append(compra.getIdUsuario()+",");
		query.append(compra.getIdMeioPagamento()+",");
		query.append(compra.getIdTipoFrete()+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				countInsert = rset.getInt(1);
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertCompra()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertCompra()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;

	}

	public int insertCompraProduto(Integer idcompra,Integer idModelo, Integer idStatus){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int countInsert  = 0;

		query.append("insert into tb_compra_item (");
		query.append("	id_compra,");
		query.append("	id_modelo,");
		query.append("	id_status) values(");
		query.append(	idcompra+",");
		query.append(	idModelo+",");
		query.append(	idStatus+")");
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countInsert = stm.executeUpdate(query.toString());

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countInsert;

	}

}
