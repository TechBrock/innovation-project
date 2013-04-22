package br.com.innovation.bo;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.enums.TipoTelefoneEnum;
import br.com.innovation.utils.MessagesUtil;
import br.com.innovation.vo.TelefoneVo;
import br.com.innovation.vo.UsuarioVo;

public class UsuarioBo implements Serializable {


	/**
	 * 
	 */

	private static final long serialVersionUID = -3561403189362829187L;

	//Objetos
	UsuarioVo usuVo = new UsuarioVo();
	UsuarioVo usuLogin = new UsuarioVo();
	TelefoneVo telResidencial = new TelefoneVo();
	TelefoneVo telComercial = new TelefoneVo();
	TelefoneVo telCelular = new TelefoneVo();

	//Arrays
	private ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();
	private List<SelectItem> perfilSelect = new ArrayList<SelectItem>();

	//Atributo
	private String diaNasc;
	private String mesNasc;
	private String anoNasc;
	private int idUsuario = 0;
	private String email;
	HttpSession session;


	public UsuarioVo getUsuVo() {
		return usuVo;
	}

	public TelefoneVo getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(TelefoneVo telResidencial) {
		this.telResidencial = telResidencial;
	}

	public TelefoneVo getTelComercial() {
		return telComercial;
	}

	public void setTelComercial(TelefoneVo telComercial) {
		this.telComercial = telComercial;
	}

	public TelefoneVo getTelCelular() {
		return telCelular;
	}

	public void setTelCelular(TelefoneVo telCelular) {
		this.telCelular = telCelular;
	}

	public void setUsuVo(UsuarioVo usuVo) {
		this.usuVo = usuVo;
	}
	public String getDiaNasc() {
		return diaNasc;
	}
	public void setDiaNasc(String diaNasc) {
		this.diaNasc = diaNasc;
	}
	public String getMesNasc() {
		return mesNasc;
	}
	public void setMesNasc(String mesNasc) {
		this.mesNasc = mesNasc;
	}
	public String getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(String anoNasc) {
		this.anoNasc = anoNasc;
	}

	public ArrayList<TelefoneVo> getTelAl() {
		return telAl;
	}

	public void setTelAl(ArrayList<TelefoneVo> telAl) {
		this.telAl = telAl;
	}

	public List<SelectItem> getPerfilSelect() {
		return perfilSelect;
	}

	public void setPerfilSelect(List<SelectItem> perfilSelect) {
		this.perfilSelect = perfilSelect;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	

	public UsuarioVo getUsuLogin() {
		return usuLogin;
	}

	public void setUsuLogin(UsuarioVo usuLogin) {
		this.usuLogin = usuLogin;
	}
	
	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
	

	public void inserir(){
		if(usuVo.getIdPerfil() == null || usuVo.getIdPerfil() <= 0){
			usuVo.setIdPerfil(1);
		}
		usuVo.setDataNascimento(anoNasc+"-"+mesNasc+"-"+diaNasc);
		usuVo.setAtivo('S');
		usuVo.setEspecial('N');

		if(!usuVo.getSenha().equals(usuVo.getConfirmaSenha())){
			MessagesUtil.exibeMensagemErro("As senhas estão diferentes!");
		}else{
			idUsuario = new UsuarioDao().insertUsuario(usuVo);
			if(idUsuario > 0){
				inserirTel(idUsuario);
				MessagesUtil.exibeMensagemInf("Cadastro efetuado com sucesso!");

			}
		}

	}


	private void inserirTel(int idUsuario){
		if(telResidencial.getDdd() != null && telResidencial.getDdd() > 0){
			telResidencial.setIdUsuario(idUsuario);
			telResidencial.setIdTipoTelefone(TipoTelefoneEnum.RESIDENCIAL.ordinal()+1);
			new TelefoneDao().insertUsuario(telResidencial);
		}


		if(telComercial.getDdd() != null && telComercial.getDdd() > 0){
			telComercial.setIdUsuario(idUsuario);
			telComercial.setIdTipoTelefone(TipoTelefoneEnum.COMERCIAL.ordinal()+1);
			new TelefoneDao().insertUsuario(telComercial);
		}

		if(telCelular.getDdd() != null && telCelular.getDdd() > 0){
			telCelular.setIdUsuario(idUsuario);
			telCelular.setIdTipoTelefone(TipoTelefoneEnum.CELULAR.ordinal()+1);
			new TelefoneDao().insertUsuario(telCelular);
		}
	}

	public String buscaEmail(){
		String existeEmail = "";

		if(email.equals(null) || email.equals("")){
			MessagesUtil.exibeMensagemAlerta("Digite seu email");
		}else{
			existeEmail = new UsuarioDao().getEmailExist(email);
			if(existeEmail==null || existeEmail.equals("")){
				return "inn003";
			}else{
				MessagesUtil.exibeMensagemAlerta("Já existe um usuário cadastrado com esse email!");

			}
		}
		return null;
	}
	
	public String login(){
		usuLogin = new UsuarioDao().getLogin(usuVo);
		session =  (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("email", usuLogin.getEmail());
		session.setAttribute("senha", usuLogin.getSenha());
		session.setAttribute("apelido", usuLogin.getApelido());
		
		System.out.println(session.getAttribute("email"));
		
		return "inn001";
	}

	//validações
	public  void validaApelido(){
		if(usuVo.getApelido().equals(null) || usuVo.getApelido().equals("")){
			MessagesUtil.exibeMensagemErro("Apelido obrigatório", "teste");
		}
	}

	public  void validaNome(){
		if(usuVo.getNome().equals(null) || usuVo.getNome().equals("")){
			MessagesUtil.exibeMensagemErro("Nome obrigatório", "validaNome");
		}
	}

	public  void validaSobrenome(){
		if(usuVo.getSobrenome().equals(null) || usuVo.getSobrenome().equals("")){
			MessagesUtil.exibeMensagemErro("Sobrenome obrigatório", "validaNome");
		}
	}

	public  void validaDataNasc(){
		if(diaNasc.equals(null)|| diaNasc.equals("")
				|| mesNasc.equals(null) || mesNasc.equals("")
				|| anoNasc.equals(null) || anoNasc.equals("")){
			MessagesUtil.exibeMensagemErro("Data de Nascimento obrigatória", "validaNome");
		}
	}

	public  void validaCPF(){
		if(usuVo.getCpf().equals(null) || usuVo.getCpf().equals("")){
			MessagesUtil.exibeMensagemErro("CPF obrigatório", "validaNome");
		}
	}

	public  void validaEmail(){
		if(usuVo.getEmail().equals(null) || usuVo.getEmail().equals("")){
			MessagesUtil.exibeMensagemErro("Email obrigatório", "validaNome");
		}
	}

	public  void validaSenha(){
		if(usuVo.getSenha().equals(null) || usuVo.getSenha().equals("")){
			MessagesUtil.exibeMensagemErro("Senha obrigatório", "validaNome");
		}
	}






}
