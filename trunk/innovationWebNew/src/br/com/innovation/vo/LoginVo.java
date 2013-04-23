package br.com.innovation.vo;

import java.io.Serializable;

public class LoginVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3923621043853088701L;
	private String email;
	private String senha;
	
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
	
	
	
	

}
