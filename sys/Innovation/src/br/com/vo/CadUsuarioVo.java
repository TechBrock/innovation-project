package br.com.vo;

import java.io.Serializable;
import java.util.Date;

public class CadUsuarioVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6717663066413493948L;
	private Integer id;
	private String nome;
	private String sobrenome;
	private Date dataNascimento;
	private char sexo;
	private String cpf;
	private String apelido;
	private String email;
	private String senha;
	private Date dataEntrada;
	private char ativo;
	private char receberEmail;
	private char especial;
	private Integer idPerfil;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public char getAtivo() {
		return ativo;
	}
	public void setAtivo(char ativo) {
		this.ativo = ativo;
	}
	public char getReceberEmail() {
		return receberEmail;
	}
	public void setReceberEmail(char receberEmail) {
		this.receberEmail = receberEmail;
	}
	public char getEspecial() {
		return especial;
	}
	public void setEspecial(char especial) {
		this.especial = especial;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
	
	
	
	
	
	

}
