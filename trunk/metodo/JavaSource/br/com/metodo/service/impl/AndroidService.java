package br.com.metodo.service.impl;

import br.com.metodo.service.dao.AndroidDAO;
import br.com.metodo.service.vo.Usuario;

public class AndroidService {
	
	private AndroidDAO androidDAO = new AndroidDAO();
	
	public boolean getLogin(String email, String senha){
		return androidDAO.getLogin(email, senha);
	}
	
	public Usuario getUsuario(String email, String senha){
		if(getLogin(email, senha)){
			return androidDAO.getUsuario(email, senha);
		}
		return null;
	}

	public String verificarLogin(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
