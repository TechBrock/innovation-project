package br.com.innovation.bo;

import br.com.innovation.dao.LoginDao;
import br.com.innovation.utils.MessagesUtil;
import br.com.innovation.vo.LoginVo;

public class LoginBo {
	LoginVo login = new LoginVo();
	LoginVo loginReturn = new LoginVo();
	boolean cliente = true;
	
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
	
	public String login(){
		loginReturn = new LoginDao().getLogin(login);
		if(loginReturn.getId() == null || loginReturn.getId() <= 0){
			MessagesUtil.exibeMensagemErro("Email e senha não correspondem!");
		}else{
			if(loginReturn.getIdPerfil() == 1){
				cliente = true;
			}else{
				cliente = false;
			}
			return "inn001";
			
		}
		return null;
		
		
		
	}
	
	public String logout(){
		loginReturn = new LoginVo();
		login = new LoginVo();
		cliente = true;
		return "inn001";
	}

}
