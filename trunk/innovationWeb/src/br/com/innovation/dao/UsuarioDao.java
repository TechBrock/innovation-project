package br.com.innovation.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import br.com.innovation.utils.Conexao;
import br.com.innovation.vo.UsuarioVo;


public class UsuarioDao {
	DateFormat frm = new SimpleDateFormat("yyyy-MM-yy");

	public Integer insertUsuario(UsuarioVo usu){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		Integer idUsuario = null;
		
		query.append("INSERT INTO TB_USUARIO (");
		query.append("NOME,");
		query.append("SOBRENOME,");
		query.append("DATA_NASCIMENTO,");
		query.append("SEXO,");
		query.append("CPF,");
		query.append("APELIDO,");
		query.append("EMAIL,");
		query.append("SENHA,");
		query.append("DATA_ENTRADA,");
		query.append("ATIVO,");
		query.append("RECEBER_EMAIL,");
		query.append("ESPECIAL,");
		query.append("ID_PERFIL");
		query.append(")VALUES(");
		query.append("'"+usu.getNome()+"',");
		query.append("'"+usu.getSobrenome()+"',");
		query.append("'"+ frm.format(usu.getDataNascimento())+"',");
		query.append("'"+usu.getSexo()+"',");
		query.append("'"+usu.getCpf()+"',");
		query.append("'"+usu.getApelido()+"',");
		query.append("'"+usu.getEmail()+"',");
		query.append("'"+usu.getSenha()+"',");
		query.append("NOW(),");
		query.append("'"+usu.getAtivo()+"',");
		query.append("'"+usu.getReceberEmail()+"',");
		query.append("'"+usu.getEspecial()+"',");
		query.append(usu.getIdPerfil()+")");

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

	public int edit(UsuarioVo usu){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		Integer countUp = null;
		
		if(usu.getSenhaNova() != null && !usu.getSenhaNova().equals("")){
			filtro.append("SENHA = '"+usu.getSenhaNova()+"',");
		}

		query.append("UPDATE TB_USUARIO SET ");
		query.append("NOME = '"+usu.getNome()+"',");
		query.append("SOBRENOME = '"+usu.getSobrenome()+"',");
		query.append("DATA_NASCIMENTO = '"+frm.format(usu.getDataNascimento())+"',");
		query.append("SEXO = '"+usu.getSexo()+"',");
		query.append("CPF = '"+usu.getCpf()+"',");
		query.append("APELIDO = '"+usu.getApelido()+"',");
		query.append("EMAIL = '"+usu.getEmail()+"',");
		query.append(filtro);
		query.append("RECEBER_EMAIL = '"+usu.getReceberEmail()+"'");
		query.append(" WHERE ID = '"+usu.getId()+"'");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			countUp = stm.executeUpdate(query.toString());
			
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".edit()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".edit()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return countUp;

	}
	
	
	public String getSenhaAtual(Integer id){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		String senhaReturn = "";
		
		query.append("SELECT senha FROM TB_USUARIO WHERE id = "+id);
		
		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());
			
			while(rset.next()){
				senhaReturn = rset.getString("senha");
			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getSenhaAtual()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getSenhaAtual()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return senhaReturn;
	}
		

	public String getEmailExist(String email){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		UsuarioVo usuVo = new UsuarioVo();

		query.append("SELECT email FROM TB_USUARIO WHERE EMAIL LIKE('"+email+"')");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			while(rset.next()){
				usuVo.setEmail(rset.getString("email"));
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
		return usuVo.getEmail();
	}

	public int getCPF(String cpf, Integer idUsuario){

		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		StringBuilder filtro = new StringBuilder();
		int id = 0;
		
		if(idUsuario > 0){
			filtro.append(" AND ID != "+idUsuario);
		}
		
		

		query.append(" SELECT id FROM TB_USUARIO WHERE upper(cpf) LIKE UPPER('"+cpf+"')");
		query.append(filtro);

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			if(rset.next()){
				id = rset.getInt("id");
			}

		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCPF()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getCPF()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return id;
	}


	public UsuarioVo getLogin(UsuarioVo usu){
		Connection conn = null;
		Statement stm = null;
		ResultSet rset = null;
		StringBuilder query = new StringBuilder();
		UsuarioVo usuVo = new UsuarioVo();

		query.append("SELECT email");
		query.append(" ,senha");
		query.append(" ,apelido");
		query.append(" FROM TB_USUARIO");
		query.append(" WHERE UPPER(email) LIKE UPPER('"+usu.getEmail()+"')");
		query.append(" AND UPPER(senha) LIKE UPPER('"+usu.getSenha()+"')");

		try{
			conn = Conexao.connect();
			stm = conn.createStatement();
			rset = stm.executeQuery(query.toString());

			if(rset.next()){

				usuVo.setEmail(rset.getString("email"));
				usuVo.setSenha(rset.getString("senha"));
				usuVo.setApelido(rset.getString("apelido"));

			}
		} catch (SQLException sqlex) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getLogin()");
			sqlex.printStackTrace();

		} catch(Exception e) {
			System.out.println("ERRO: "+getClass().getCanonicalName()+".getLogin()");
			e.printStackTrace();

		} finally {
			Conexao.disconnect(rset, stm, conn);
		}
		return usuVo;
	}
}
