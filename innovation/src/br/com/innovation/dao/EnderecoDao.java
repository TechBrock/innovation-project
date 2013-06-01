package br.com.innovation.dao;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.innovation.enums.EstadoEnum;
import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.EnderecoVo;

public class EnderecoDao {

	public int insertEndereco(EnderecoVo endVo){
		Connection conn = null;
		Statement stm = null;
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

	public EnderecoVo  getEndByUser(Integer id){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		EnderecoVo endVo = new EnderecoVo();

		query.append("SELECT  cep");
		query.append("	,ende.id");
		query.append("	,tipo");
		query.append("	,logradouro");
		query.append("	,numero");
		query.append("	,complemento");
		query.append("	,bairro ");
		query.append("	,cid.nome AS cidade");
		query.append("	,est.nome AS estado");
		query.append("	FROM tb_endereco ende");
		query.append("	INNER JOIN tb_cidade cid ON ende.id_cidade = cid.id");
		query.append("	INNER JOIN tb_estado est ON cid.id_estado = est.id;");
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			while(rset.next()){
				endVo = new EnderecoVo();
				
				 	endVo.setCep(rset.getString("cep"));
				 	endVo.setId(rset.getInt("id"));
					endVo.setTipo(rset.getString("tipo"));
					endVo.setLogradouro(rset.getString("logradouro"));
					endVo.setNumero(rset.getString("numero"));
					endVo.setComplemento(rset.getString("complemento"));
					endVo.setBairro(rset.getString("bairro"));
					endVo.setNomeCidade(rset.getString("cidade"));
					endVo.setNomeEstado(rset.getString("estado"));
					endVo.setUf(EstadoEnum.getUfEstado(rset.getString("estado")));
				
			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getEndByUser()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getEndByUser()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(null, stm, conn);
		}
		return endVo;

	}


	public int getEstado(String estado){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int idEstado = 0;
		query.append("SELECT id FROM tb_estado WHERE UPPER(nome) LIKE UPPER(estado)"); 
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			if(rset.next()){
				idEstado = rset.getInt("id");
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getEstado()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getEstado()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return idEstado;
	}

	public int getCidade(String cidade){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		int idCidade = 0;

		query.append("SELECT id FROM TB_CIDADE WHERE UPPER(nome) LIKE UPPER ('"+cidade+"')");
		try{

			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				idCidade = rset.getInt("id");
			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCidade()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCidade()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return idCidade;
	}	

	public int insertCidade(String nomeCidade, int idEstado){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		Integer countCidade = 0;

		query.append("INSERT INTO TB_CIDADE (nome, id_estado) values('"+nomeCidade+"', "+idEstado+")");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			stm.executeUpdate(query.toString(), Statement.RETURN_GENERATED_KEYS);
			rset = stm.getGeneratedKeys();

			if(rset.next()){
				countCidade = rset.getInt(1);
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertCidade()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".insertCidade()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countCidade;
	}
}
