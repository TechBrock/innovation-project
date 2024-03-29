package br.com.innovation.bo;

import java.io.Serializable;

import javax.faces.context.FacesContext;

import org.ajax4jsf.component.html.HtmlPage;

import br.com.innovation.dao.EnderecoDao;
import br.com.innovation.dao.LoginDao;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.vo.LoginVo;

public class LoginBo implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3165125601068089280L;
	LoginVo login = new LoginVo();
	LoginVo loginReturn = new LoginVo();
	boolean cliente = true;
	boolean cadValido = true;
	boolean emailValido = true;
	boolean senhaValida = true;
	private Integer idLogado;
	private String acao = "inn001";

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
	public Integer getIdLogado() {
		return idLogado;
	}
	public void setIdLogado(Integer idLogado) {
		this.idLogado = idLogado;
	}
	public String getAcao() {
		return acao;
	}
	public void setAcao(String acao) {
		this.acao = acao;
	}
	public void clean(){
		cadValido = true;
		emailValido = true;
		senhaValida = true;
	}


	public String login(){
		if(validaDados(login)){
			emailValido = true;
			senhaValida = true;
			loginReturn = new LoginDao().getLogin(login);


			if(loginReturn.getId() == null || loginReturn.getId() <= 0){
				cadValido = false;
			}else{
				if(loginReturn.getIdPerfil() == 1){
					cliente = true;
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("id", loginReturn.getId());
					idLogado = loginReturn.getId();
				}else{
					cliente = false;
					acao = "inn001";
				}

				return acao;

			}
		}
		return null;
	}

	public String loginCad(LoginVo loginVo){
		loginReturn = new LoginDao().getLogin(loginVo);
		return "inn001";

	}


	public String logout(){
		loginReturn = new LoginVo();
		login = new LoginVo();
		cliente = true;
		new CarrinhoBo().zeraCarrinho();
		return "inn001";
	}

	private boolean validaDados(LoginVo login){
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
