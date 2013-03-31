package br.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import br.com.vo.CadUsuarioVo;

public class CadUsuarioDao {

	private Connection conn = null;
	private Statement stm = null;
	private ResultSet rset = null;

	public void insert(CadUsuarioVo cusuVo){
		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO TB_USUARIO(");
		query.append(" NOME");
		query.append(" ,SOBRENOME");
		query.append(" ,DATA_NASCIMENTO");
		query.append(" ,SEXO");
		query.append(" ,CPF");
		query.append(" ,APELIDO");
		query.append(" ,EMAIL");
		query.append(" ,SENHA");
		query.append(" ,DATA_ENTRADA");
		query.append(" ,DATA_ULTIMA_MODIFICACAO");
		query.append(" ,ATIVO");
		query.append(" ,RECEBER_EMAIL");
		query.append(" ,ESPECIAL");
		query.append(" ,ID_PERFIL");
		query.append(") VALUES(");
		query.append( "'"+cusuVo.getNome()+"',");
		query.append( "'"+cusuVo.getSobrenome()+"',");
		query.append( new java.sql.Date(cusuVo.getDataNasc().getTime())+",");
		query.append( "'"+cusuVo.getSexo()+"',");
		query.append( "'"+cusuVo.getCpf()+"',");
		query.append( "'"+cusuVo.getApelido()+"',");
		query.append( "'"+cusuVo.getEmail()+"',");
		query.append( "'"+cusuVo.getSenha()+"',");
		query.append( new java.sql.Date(cusuVo.getDataEntrada().getTime())+",");
		query.append( new java.sql.Date(cusuVo.getDataModif().getTime())+",");
		query.append( "'"+cusuVo.getAtivo()+"',");
		query.append( "'"+cusuVo.getReceberEmail()+"',");
		query.append( "'"+cusuVo.getEspecial()+"',");
		query.append( cusuVo.getIdPerfil()+")");

		try{
			conn = Conexao.open;
			stm =conn.createStatement();
			stm.executeUpdate(query.toString());

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public void insert(CadUsuarioVo cusuVo){
		StringBuilder query = new StringBuilder();

		query.append("INSERT INTO TB_USUARIO(");
		query.append(" NOME");
		query.append(" ,SOBRENOME");
		query.append(" ,DATA_NASCIMENTO");
		query.append(" ,SEXO");
		query.append(" ,CPF");
		query.append(" ,APELIDO");
		query.append(" ,EMAIL");
		query.append(" ,SENHA");
		query.append(" ,DATA_ENTRADA");
		query.append(" ,DATA_ULTIMA_MODIFICACAO");
		query.append(" ,ATIVO");
		query.append(" ,RECEBER_EMAIL");
		query.append(" ,ESPECIAL");
		query.append(" ,ID_PERFIL");
		query.append(") VALUES(");
		query.append( "'"+cusuVo.getNome()+"',");
		query.append( "'"+cusuVo.getSobrenome()+"',");
		query.append( new java.sql.Date(cusuVo.getDataNasc().getTime())+",");
		query.append( "'"+cusuVo.getSexo()+"',");
		query.append( "'"+cusuVo.getCpf()+"',");
		query.append( "'"+cusuVo.getApelido()+"',");
		query.append( "'"+cusuVo.getEmail()+"',");
		query.append( "'"+cusuVo.getSenha()+"',");
		query.append( new java.sql.Date(cusuVo.getDataEntrada().getTime())+",");
		query.append( new java.sql.Date(cusuVo.getDataModif().getTime())+",");
		query.append( "'"+cusuVo.getAtivo()+"',");
		query.append( "'"+cusuVo.getReceberEmail()+"',");
		query.append( "'"+cusuVo.getEspecial()+"',");
		query.append( cusuVo.getIdPerfil()+")");

		try{
			conn = Conexao.open;
			stm =conn.createStatement();
			stm.executeUpdate(query.toString());

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			Conexao.close(rset,stm,conn);
		}

	}

	public void update(CadUsuarioVo cusuVo){
		StringBuilder query = new StringBuilder();

		query.append("UPDATE INTO TB_USUARIO SET ");
		query.append(" NOME = '"+cusuVo.getNome()+"'");
		query.append(" ,SOBRENOME = '"+cusuVo.getSobrenome()+"'");
		query.append(" ,DATA_NASCIMENTO = "+cusuVo.getDataNasc());
		query.append(" ,SEXO = '"+cusuVo.getSexo()+"'");
		query.append(" ,CPF = '"+cusuVo.getCpf()+"'");
		query.append(" ,APELIDO = '"+cusuVo.getApelido()+"'");
		query.append(" ,EMAIL = '"+cusuVo.getEmail()+"'");
		query.append(" ,SENHA = '"+cusuVo.getSenha()+"'");
		query.append(" ,DATA_ENTRADA = "+cusuVo.getDataEntrada());
		query.append(" ,DATA_ULTIMA_MODIFICACAO = "+cusuVo.getDataModif());
		query.append(" ,ATIVO = '"+cusuVo.getAtivo()+"'");
		query.append(" ,RECEBER_EMAIL = '"+cusuVo.getReceberEmail()+"'");
		query.append(" ,ESPECIAL = '"+cusuVo.getEspecial()+"'");
		query.append(" ,ID_PERFIL = '"+cusuVo.getIdPerfil()+"'");


		try{
			conn = Conexao.open;
			stm =conn.createStatement();
			stm.executeUpdate(query.toString());

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			Conexao.close(rset,stm,conn);
		}

	}

	public CadUsuarioVo getUsuario(String cpf){
		StringBuilder query = new StringBuilder();
		CadUsuarioVo cusuResult = new CadUsuarioVo();

		query.append("SELECT * FROM TB_USUARIO");
		query.append(" WHERE CPF LIKE "+cpf);


		try{
			conn = Conexao.open;
			stm =conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				cusuResult = new CadUsuarioVo();
				cusuResult.setId(rset.getInt("ID"));
				cusuResult.setNome(rset.getString("NOME"));
				cusuResult.setSobrenome(rset.getString("SOBRENOME"));
				cusuResult.setDataNasc(rset.getTimestamp("DATA_NASCIMENTO"));
				cusuResult.setSexo(rset.getCharacterStream("SEXO"));
				cusuResult.setCpf(rset.getString("CPF"));
				cusuResult.setApelido(rset.getString("APELIDO"));
				cusuResult.setEmail(rset.getString("EMAIL"));
				cusuResult.setSenha(rset.getString("SENHA"));
				cusuResult.setDataEntrada(rset.getTimestamp("DATA_ENTRADA"));
				cusuResult.setDataModif(rset.getTimestamp("DATA_ULTIMA_MODIFICACAO"));
				cusuResult.setAtivo(rset.getCharacterStream("ATIVO"));
				cusuResult.setReceberEmail(rset.getCharacterStream("RECEBER_EMAIL"));
				cusuResult.setEspecial(rset.getCharacterStream("ESPECIAL"));
				cusuResult.setIdPerfil(rset.getInt("ID_PERFIL"));
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally{
			Conexao.close(rset,stm,conn);
		}

		return cusuResult;

	}



}
