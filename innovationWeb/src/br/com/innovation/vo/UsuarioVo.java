package br.com.innovation.vo;

import java.io.Serializable;
import java.util.Date;

public class UsuarioVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8751826646345716326L;
	
	private Integer usuario;
	private Integer idPerfil;
	private String nome;
	private String sobrenome;
	private String cpf;
	private String apelido;
	private String email;
	private String senha;
	private String confirmaSenha;
	private Date dataNascimento;
	private Date dataEntrada;
	private char sexo;
	private char ativo;
	private char receberEmail;
	private char especial;
	
	
	public Integer getUsuario() {
		return usuario;
	}
	public void setUsuario(Integer usuario) {
		this.usuario = usuario;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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
	public String getConfirmaSenha() {
		return confirmaSenha;
	}
	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
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
	
}
	
	
