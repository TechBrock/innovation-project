package br.com.innovation.service.boleto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.BoletoVo;
import br.com.innovation.vo.UsuarioVo;

public class BoletoDao {
	
	public Integer insertBoleto(BoletoVo boleto){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		Integer idUsuario = null;
		
		/*
 		ID INTEGER NOT NULL AUTO_INCREMENT,
	    PRIMARY KEY (ID),
	    DATA_PROCESSAMENTO DATE NOT NULL,
	    DATA_DOCUMENTO DATE NOT NULL,
		DATA_VENCIMENTO DATE NOT NULL,
		ID_CLIENTE INTEGER NOT NULL,
		ID_COMPRA INTEGER NOT NULL,
		VALOR_BOLETO NUMERIC NOT NULL
		 */
		
		query.append("INSERT INTO TB_MD_BOLETO (");
		query.append("DATA_PROCESSAMENTO,");
		query.append("DATA_DOCUMENTO,");
		query.append("DATA_VENCIMENTO,");
		query.append("ID_CLIENTE,");
		query.append("ID_COMPRA,");
		query.append("VALOR_BOLETO,");
		query.append(")VALUES(");
		query.append("'"+boleto.getDataProcessamento()+"',");
		query.append("'"+boleto.getDataDocumento()+"',");
		query.append("'"+boleto.getDataVencimento()+"',");
		query.append("'"+boleto.getIdCliente()+"',");
		query.append("'"+boleto.getIdCompra()+"',");
		query.append("'"+boleto.getValorBoleto()+"',");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				idUsuario = rset.getInt(1);
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertUsuario()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return idUsuario;

	}
	
	
	
	
	
	
	
	
	
	public UsuarioVo getUsuarioById(Integer id){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		UsuarioVo usuVo = new UsuarioVo();


		query.append("SELECT id,");
		query.append("	nome, ");
		query.append("	sobrenome,");
		query.append("	data_nascimento,");
		query.append("	sexo,");
		query.append("	cpf,");
		query.append("	apelido,");
		query.append("	email,");
		query.append("	senha,");
		query.append("	data_entrada,");
		query.append("	ativo,");
		query.append("	receber_email,");
		query.append("	id_perfil");
		query.append("	from TB_USUARIO");
		query.append("	WHERE id = "+id);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());


			while(rset.next()){
				usuVo = new UsuarioVo();
				usuVo.setId(rset.getInt("id"));
				usuVo.setNome(rset.getString("nome"));
				usuVo.setSobrenome(rset.getString("sobrenome"));
				usuVo.setDataNascimento(rset.getDate("data_nascimento"));

				if(rset.getString("sexo").equals("F")){
					usuVo.setSexo('F');
				}else{
					usuVo.setSexo('M');
				}

				usuVo.setCpf(rset.getString("cpf"));
				usuVo.setApelido(rset.getString("apelido"));
				usuVo.setEmail(rset.getString("email"));
				usuVo.setSenha(rset.getString("senha"));

				if(rset.getString("receber_email").equals("S")){
					usuVo.setReceberEmail('S');
				}else{
					usuVo.setReceberEmail('N');
				}
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getUsuario()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getUsuario()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return usuVo;

	}
}
