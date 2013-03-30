package br.com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.conect.Conexao;
import br.com.vo.CadUsuarioVo;

public class CadUsuarioDao {
	Connection conn = null;
	Statement stm = null;
	ResultSet rset = null;

	public String insert(CadUsuarioVo usuVo){

		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO TB_USUARIO(");
		query.append("nome,");
		query.append("sobrenome,");
		query.append("data_de_nascimento,");
		query.append("sexo,");
		query.append("cpf,");
		query.append("apelido,");
		query.append("email,");
		query.append("senha,");
		query.append("data_de_entrada_sistema,");
		query.append("data_ultima_modificacao,");
		query.append("ativo,");
		query.append("perfil) values(");
		query.append("'"+usuVo.getNome()+"',");
		query.append("'"+usuVo.getSobrenome()+"',");
		query.append(new java.sql.Date(usuVo.getDataNascimento().getTime())+",");
		query.append("'"+usuVo.getSexo()+"',");
		query.append("'"+usuVo.getCpf()+"',");
		query.append("'"+usuVo.getApelido()+"',");
		query.append("'"+usuVo.getEmail()+"',");
		query.append("'"+usuVo.getSenha()+"',");
		query.append("now(),");
		query.append("now(),");
		query.append("'S'");
		query.append(usuVo.getPerfil());

		try{
			conn = Conexao.open(conn);
			stm = conn.createStatement();
			stm.executeUpdate(query.toString());

		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("CadUsuarioDao().isert()");
		}finally{
			Conexao.close(rset, stm, conn);
		}

		return "sucess";
	}

	public String update(CadUsuarioVo usuVo){
		StringBuilder query = new StringBuilder();
		query.append("UPDATE TB_USUARIO ");
		query.append("nome = '"+usuVo.getNome()+"'");
		query.append(",sobrenome='"+usuVo.getSobrenome()+"'");
		query.append(",data_de_nascimento = "+new java.sql.Date(usuVo.getDataNascimento().getTime()));
		query.append(",sexo = '"+usuVo.getSexo()+"'");
		query.append(",cpf = '"+usuVo.getCpf()+"'");
		query.append(",apelido = '"+usuVo.getApelido()+"'");
		query.append(",email = '"+usuVo.getEmail()+"'");
		query.append("senha = '"+usuVo.getSenha()+"'");
		query.append("data_de_entrada_sistema = "+ new java.sql.Date(usuVo.getDataEntradaSistema().getTime()));
		query.append("data_ultima_modificacao = now()");
		query.append("ativo ='"+usuVo.getAtivo()+"'");
		query.append("perfil ="+usuVo.getPerfil());

		try{
			conn = Conexao.open(conn);
			stm = conn.createStatement();
			stm.executeUpdate(query.toString());

		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("CadUsuarioDao().update()");
		}finally{
			Conexao.close(rset, stm, conn);
		}

		return "sucess";
	}

	public CadUsuarioVo getUsuario(String cpfParam){
		StringBuilder query = new StringBuilder();
		CadUsuarioVo cusuVo = new CadUsuarioVo();

		query.append(" SELECT * FROM TAB_USUARIO");
		query.append(" WHERE UPPER(CPF) LIKE UPPER ('"+cpfParam+"')");

		try{
			conn = Conexao.open(conn);
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				cusuVo.setId(rset.getInt("id"));
				cusuVo.setNome(rset.getString("nome"));
				cusuVo.setSobrenome(rset.getString("sobrenome"));
				cusuVo.setDataNascimento(rset.getTimestamp("data_de_nascimento"));
				cusuVo.setSexo(rset.getString("sexo"));
				cusuVo.setCpf(rset.getString("cpf"));
				cusuVo.setApelido(rset.getString("apelido"));
				cusuVo.setEmail(rset.getString("email"));
				cusuVo.setSenha(rset.getString("senha"));
				cusuVo.setDataEntradaSistema(rset.getTimestamp("data_de_entrada_sistema"));
				cusuVo.setDataModificacao(rset.getTimestamp("data_ultima_modificacao,"));
				cusuVo.setAtivo(rset.getString("ativo"));
				cusuVo.setPerfil(rset.getInt("perfil"));

			}


		}catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("CadUsuarioDao().update()");
		}finally{
			Conexao.close(rset, stm, conn);
		}

		return cusuVo;
	}

}
