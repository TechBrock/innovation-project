package br.com.mb;

import br.com.vo.LoginVo;

public class LoginMb {
	private LoginVo log = new LoginVo();
	
	
	public LoginVo getLog() {
		return log;
	}
	public void setLog(LoginVo log) {
		this.log = log;
	}
	
	

	public String logar(){
		return "BemVindo";
		
	}

}
