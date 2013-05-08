package br.com.innovation.bo;

import br.com.innovation.dao.LoginDao;
import br.com.innovation.vo.LoginVo;

public class LoginBo {
	LoginVo login = new LoginVo();
	LoginVo loginReturn = new LoginVo();
	boolean cliente = true;
	boolean cadValido = true;
	boolean emailValido = true;
	boolean senhaValida = true;

	public LoginVo getLogin() {
		return login;
	}
	public void setLogin(LoginVo login) {
		this.login = login;
	}
	public LoginVo getLoginReturn() {
		return loginReturn;
	}
	public void setLoginReturn(LoginVo loginReturn) {
		this.loginReturn = loginReturn;
	}
	public boolean isCliente() {
		return cliente;
	}
	public void setCliente(boolean cliente) {
		this.cliente = cliente;
	}


	public boolean isCadValido() {
		return cadValido;
	}
	public void setCadValido(boolean cadValido) {
		this.cadValido = cadValido;
	}
	public boolean isEmailValido() {
		return emailValido;
	}
	public void setEmailValido(boolean emailValido) {
		this.emailValido = emailValido;
	}
	public boolean isSenhaValida() {
		return senhaValida;
	}
	public void setSenhaValida(boolean senhaValida) {
		this.senhaValida = senhaValida;
	}
	public String login(){
		if(validaDados()){
			emailValido = true;
			senhaValida = true;
			loginReturn = new LoginDao().getLogin(login);
			if(loginReturn.getId() == null || loginReturn.getId() <= 0){
				cadValido = false;
			}else{
				if(loginReturn.getIdPerfil() == 1){
					cliente = true;
				}else{
					cliente = false;
				}
				return "inn001";

			}
		}
		return null;
	}
	
	public void loginCad(LoginVo loginVo){
		if(validaDados()){
			emailValido = true;
			senhaValida = true;
			loginReturn = new LoginDao().getLogin(loginVo);
			if(loginReturn.getId() == null || loginReturn.getId() <= 0){
				cadValido = false;
			}else{
				if(loginReturn.getIdPerfil() == 1){
					cliente = true;
				}else{
					cliente = false;
				}

			}
		}
	}


	public String logout(){
		loginReturn = new LoginVo();
		login = new LoginVo();
		cliente = true;
		return "inn001";
	}

	private boolean validaDados(){
		boolean ok = true;
		if(login.getEmail() == null || login.getEmail().equals("")){
			emailValido = false;
			ok = false;
		}

		if(login.getSenha() == null || login.getEmail().equals("")){
			senhaValida = false;
			ok = false;
		}

		return ok;
	}

}
