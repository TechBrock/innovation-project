package br.com.innovation.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.EnderecoVo;

public class EnderecoDao {

	public int insertEndereco(EnderecoVo endVo){
		Connection conn = null;
		Statement stm = null;
		Result rset = null;
		StringBuilder query = new StringBuilder();
		int idEnd = 0;

		query.append("INSERT INTO TB_ENDERECO(");
		query.append("CEP");
		query.append(",TIPO");
		query.append(",LOGRADOURO");
		query.append(",NUMERO");
		query.append(",COMPLEMENTO");
		query.append(",BAIRRO");
		query.append(",INFORMACOES_ADICIONAIS");
		query.append(",ID_USUARIO");
		query.append(",ID_CIDADE ) VALUES(");
		query.append("'"+endVo.getCep()+"',");
		query.append("'"+endVo.getTipo()+"',");
		query.append("'"+endVo.getLogradouro()+"',");
		query.append("'"+endVo.getNumero()+"',");
		query.append("'"+endVo.getComplemento()+"',");
		query.append("'"+endVo.getBairro()+"',");
		query.append("'"+endVo.getInfAdc()+"',");
		query.append("'"+endVo.getIdUsuario()+"',");
		query.append("'"+endVo.getIdCidade()+"')");
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			idEnd = stm.executeUpdate(query.toString());
			
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertEndereco()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertEndereco()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(null, stm, conn);
		}
		return idEnd;
	}

}
