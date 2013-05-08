package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.enums.TipoTelefoneEnum;
import br.com.innovation.vo.LoginVo;
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
	private Integer diaNasc = 1;
	private Integer mesNasc = 1;
	private Integer anoNasc = 1;
	private int idUsuario = 0;
	private String email;
	private Boolean apelidoValido = true;
	private Boolean nomeValido = true;
	private Boolean sobrenomeValido = true;
	private Boolean dataNascValido = true;
	private Boolean dataNasc2Valido = true;
	private Boolean cpfValido = true;
	private Boolean telefoneValido = true;
	private Boolean emailValido = true;
	private Boolean senhaValido = true;
	private Boolean confirmValido = true;
	private Boolean telValido = true;
	private String erroSubmit = "teste";

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
	public Integer getDiaNasc() {
		return diaNasc;
	}
	public void setDiaNasc(Integer diaNasc) {
		this.diaNasc = diaNasc;
	}
	public Integer getMesNasc() {
		return mesNasc;
	}
	public void setMesNasc(Integer mesNasc) {
		this.mesNasc = mesNasc;
	}
	public Integer getAnoNasc() {
		return anoNasc;
	}
	public void setAnoNasc(Integer anoNasc) {
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
	public Boolean getApelidoValido() {
		return apelidoValido;
	}
	public void setApelidoValido(Boolean apelidoValido) {
		this.apelidoValido = apelidoValido;
	}
	public Boolean getNomeValido() {
		return nomeValido;
	}
	public void setNomeValido(Boolean nomeValido) {
		this.nomeValido = nomeValido;
	}
	public Boolean getSobrenomeValido() {
		return sobrenomeValido;
	}
	public void setSobrenomeValido(Boolean sobrenomeValido) {
		this.sobrenomeValido = sobrenomeValido;
	}
	public Boolean getDataNascValido() {
		return dataNascValido;
	}
	public void setDataNascValido(Boolean dataNascValido) {
		this.dataNascValido = dataNascValido;
	}

	public Boolean getDataNasc2Valido() {
		return dataNasc2Valido;
	}
	public void setDataNasc2Valido(Boolean dataNasc2Valido) {
		this.dataNasc2Valido = dataNasc2Valido;
	}
	public Boolean getCpfValido() {
		return cpfValido;
	}
	public void setCpfValido(Boolean cpfValido) {
		this.cpfValido = cpfValido;
	}
	public Boolean getTelefoneValido() {
		return telefoneValido;
	}
	public void setTelefoneValido(Boolean telefoneValido) {
		this.telefoneValido = telefoneValido;
	}
	public Boolean getEmailValido() {
		return emailValido;
	}
	public void setEmailValido(Boolean emailValido) {
		this.emailValido = emailValido;
	}
	public Boolean getSenhaValido() {
		return senhaValido;
	}
	public void setSenhaValido(Boolean senhaValido) {
		this.senhaValido = senhaValido;
	}
	public Boolean getConfirmValido() {
		return confirmValido;
	}
	public void setConfirmValido(Boolean confirmValido) {
		this.confirmValido = confirmValido;
	}
	public Boolean getTelValido() {
		return telValido;
	}
	public void setTelValido(Boolean telValido) {
		this.telValido = telValido;
	}

	public String getErroSubmit() {
		return erroSubmit;
	}
	public void setErroSubmit(String erroSubmit) {
		this.erroSubmit = erroSubmit;
	}
	public String inserir(){
		int cpfExist = 0;
		boolean insere = true;
		
		validaUsuario();
		LoginVo login = new LoginVo();
		if(apelidoValido && nomeValido && sobrenomeValido && dataNascValido && cpfValido &&
				telefoneValido && emailValido && senhaValido && confirmValido){
			usuVo.setCpf(usuVo.getCpf().replaceAll("-",""));
			usuVo.setCpf(usuVo.getCpf().replace(".",""));

			if(usuVo.getIdPerfil() == null || usuVo.getIdPerfil() <= 0){
				usuVo.setIdPerfil(1);
			}
			usuVo.setAtivo('S');
			usuVo.setEspecial('N');
			
			cpfExist = new UsuarioDao().getCPF(usuVo.getCpf());
			if(cpfExist > 0){
				setErroSubmit("CPF já cadastrado!");
				insere = false;
			}
			
			if(!usuVo.getSenha().equals(usuVo.getConfirmaSenha())){
				setErroSubmit("As senhas estão diferentes!");
				insere = false;
			}
			
			if(insere){
				idUsuario = new UsuarioDao().insertUsuario(usuVo);
				if(idUsuario > 0){
					inserirTel(idUsuario);
					setErroSubmit("Cadastro efetuado com sucesso!");
					login.setEmail(usuVo.getEmail());
					login.setSenha(usuVo.getSenha());
					new LoginBo().loginCad(login);
					return "inn002";

				}
			}
		}
		telCelular = new TelefoneVo();
		telComercial = new TelefoneVo();
		return "inn003return";
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
			setErroSubmit("Digite seu email");
		}else{
			existeEmail = new UsuarioDao().getEmailExist(email);
			if(existeEmail==null || existeEmail.equals("")){
				usuVo.setEmail(email);
				return "inn003return";
			}else{
				emailValido = false;
				setErroSubmit("Já existe um usuário cadastrado com esse email!");

			}
		}
		return null;
	}


	//validações
	public  void validaUsuario(){
		if(usuVo.getApelido().equals(null) || usuVo.getApelido().equals("")){
			apelidoValido = false;
		}

		if(usuVo.getNome().equals(null) || usuVo.getNome().equals("")){
			nomeValido = false;
		}
		if(usuVo.getSobrenome().equals(null) || usuVo.getSobrenome().equals("")){
			sobrenomeValido = false;

		}

		if(usuVo.getCpf() == null || usuVo.getCpf().equals("")){
			cpfValido = false;

		}

		if(usuVo.getEmail().equals(null) || usuVo.getEmail().equals("")){
			emailValido = false;
		}

		if(usuVo.getSenha().equals(null) || usuVo.getSenha().equals("")){
			senhaValido = false;
		}

		if(telResidencial.getDdd() == null || telResidencial.getDdd() <= 0
				|| telResidencial.getNumero().equals(null) || telResidencial .getNumero() <= 0 ){
			telefoneValido = false;
		}

	}
}