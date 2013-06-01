package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.ModeloVo;
import br.com.innovation.vo.PedidoVo;

public class PedidoDao {
	public  ArrayList<PedidoVo> getPedido(Integer idUser){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		PedidoVo pedido = new PedidoVo();
		ArrayList<PedidoVo> pedidoAl = new ArrayList<PedidoVo>();

		query.append("SELECT id,");
		query.append("	ordem_compra,");
		query.append("	data_pedido,");
		query.append("	valor_compra,");
		query.append("	valor_frete,");
		query.append("	(valor_compra + valor_frete) as total");
		query.append("	from tb_compra");
		query.append("	where id_usuario ="+idUser);
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			while (rset.next()){
				
				pedido = new PedidoVo();
				pedido.setId(rset.getInt("id"));
				pedido.setOrdemCompra(rset.getInt("ordem_compra"));
				pedido.setValorCompra(rset.getDouble("valor_compra"));
				pedido.setValorFrete(rset.getDouble("valor_frete"));
				pedido.setValorTotal(rset.getDouble("total"));
				pedidoAl.add(pedido);
				
				
			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPedido()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getPedido()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return pedidoAl;

	}
	
}
