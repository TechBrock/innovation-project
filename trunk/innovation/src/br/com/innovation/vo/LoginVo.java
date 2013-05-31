package br.com.innovation.vo;

import java.io.Serializable;

public class LoginVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3923621043853088701L;
	private Integer id;
	private Integer idPerfil;
	private String email;
	private String senha;
	private String apelido;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
}
