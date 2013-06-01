package br.com.metodo.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.metodo.service.vo.ProdutoVo;
import br.com.metodo.service.vo.Usuario;
import br.com.metodo.util.Conexao;

public class AndroidDAO {

	public boolean getLogin(String email, String senha){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		String senhaRetorno = null;

		query.append("SELECT SENHA FROM tb_usuario WHERE EMAIL=");
		query.append("'"+email+"';");
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			if(rset.next()){
				senhaRetorno = rset.getString(1);
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		
		if(senhaRetorno!=null && senha.equals(senhaRetorno)){
			return true;
		}
		return false;

	}
	
	
	public Usuario getUsuario(String email, String senha){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		Usuario usuarioRetorno = new Usuario();

		query.append("SELECT " +
				"tb_usuario.NOME," +
				"tb_usuario.SOBRENOME," +
				"tb_usuario.DATA_NASCIMENTO," +
				"tb_usuario.SEXO," +
				"tb_usuario.CPF," +
				"tb_usuario.APELIDO," +
				"tb_usuario.EMAIL," +
				"tb_usuario.SENHA," +
				"tb_usuario.ATIVO," +
				"tb_usuario.RECEBER_EMAIL," +
				"tb_endereco.CEP," +
				"tb_endereco.TIPO," +
				"tb_endereco.LOGRADOURO," +
				"tb_endereco.NUMERO," +
				"tb_endereco.COMPLEMENTO," +
				"tb_endereco.BAIRRO," +
				"tb_endereco.INFORMACOES_ADICIONAIS," +
				"tb_cidade.NOME," +
				"tb_estado.NOME, " +
				"tb_usuario.ID "+
				"FROM tb_usuario " +
				"INNER JOIN tb_endereco ON tb_usuario.ID = tb_endereco.ID_USUARIO " +
				"INNER JOIN tb_cidade ON tb_endereco.ID_CIDADE = tb_cidade.ID " +
				"INNER JOIN tb_estado ON tb_cidade.ID_ESTADO = tb_estado.ID " +
				"WHERE EMAIL = ");
		query.append("'"+email+"';");
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			if(rset.next()){
				usuarioRetorno.setNome(rset.getString(1));
				usuarioRetorno.setSobrenome(rset.getString(2));
				usuarioRetorno.setDataNascimento(rset.getDate(3));
				usuarioRetorno.setSexo(rset.getString(4).charAt(0));
				usuarioRetorno.setCpf(rset.getString(5));
				usuarioRetorno.setApelido(rset.getString(6));
				usuarioRetorno.setEmail(rset.getString(7));
				usuarioRetorno.setSenha(rset.getString(8));
				usuarioRetorno.setAtivo(rset.getString(9).charAt(0));
				usuarioRetorno.setReceberEmail(rset.getString(10).charAt(0));
				usuarioRetorno.setCep(rset.getString(11));
				usuarioRetorno.setTipoLogradouro(rset.getString(12));
				usuarioRetorno.setLogradouro(rset.getString(13));
				usuarioRetorno.setNumeroEndereco(rset.getString(14));
				usuarioRetorno.setComplementoEndereco(rset.getString(15));
				usuarioRetorno.setBairro(rset.getString(16));
				usuarioRetorno.setInformacoesAdicionais(rset.getString(17));
				usuarioRetorno.setCidade(rset.getString(18));
				usuarioRetorno.setEstado(rset.getString(19));
				usuarioRetorno.setId(rset.getInt(20));
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".consultarEstoque()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		
		return usuarioRetorno;

	}
	
}
