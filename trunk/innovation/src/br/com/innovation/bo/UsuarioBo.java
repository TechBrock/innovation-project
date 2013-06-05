package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;

import org.apache.poi.hssf.record.EndRecord;

import br.com.innovation.dao.EnderecoDao;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.enums.EstadoEnum;
import br.com.innovation.enums.TipoTelefoneEnum;
import br.com.innovation.service.CorreiosService;
import br.com.innovation.vo.CidadeVo;
import br.com.innovation.vo.EnderecoVo;
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
	UsuarioVo usuEdit = new UsuarioVo();
	UsuarioVo usuLogin = new UsuarioVo();
	TelefoneVo telResidencial = new TelefoneVo();
	TelefoneVo telComercial = new TelefoneVo();
	TelefoneVo telCelular = new TelefoneVo();
	TelefoneVo telResidencialEdit = new TelefoneVo();
	TelefoneVo telComercialEdit = new TelefoneVo();
	TelefoneVo telCelularEdit = new TelefoneVo();
	EnderecoVo enderecoIns = new EnderecoVo();



	//Arrays
	private ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();
	private List<SelectItem> perfilSelect = new ArrayList<SelectItem>();

	//Atributo
	private Integer diaNasc = 1;
	private Integer mesNasc = 1;
	private Integer anoNasc = 1;
	private int idUsuario = 0;
	private String email;
	private String cep;
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
	private Boolean endValido = true;
	private Boolean numValido = true;
	private Boolean compValido = true;
	private Boolean bairroValido = true;
	private Boolean cidadeValido = true;
	private Boolean estadoValido = true;
	private Boolean paisValido = true;
	private Boolean infValido = true;
	private Boolean cepValido = true;
	private Boolean tipoValido = true;
	EnderecoVo enderecoEdit = new EnderecoVo();

	private String erroSubmit;
	private Integer idUser;

	public UsuarioVo getUsuVo() {
		return usuVo;
	}

	public UsuarioVo getUsuEdit() {
		return usuEdit;
	}

	public void setUsuEdit(UsuarioVo usuEdit) {
		this.usuEdit = usuEdit;
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
	public TelefoneVo getTelResidencialEdit() {
		return telResidencialEdit;
	}

	public void setTelResidencialEdit(TelefoneVo telResidencialEdit) {
		this.telResidencialEdit = telResidencialEdit;
	}

	public TelefoneVo getTelComercialEdit() {
		return telComercialEdit;
	}

	public void setTelComercialEdit(TelefoneVo telComercialEdit) {
		this.telComercialEdit = telComercialEdit;
	}

	public TelefoneVo getTelCelularEdit() {
		return telCelularEdit;
	}

	public void setTelCelularEdit(TelefoneVo telCelularEdit) {
		this.telCelularEdit = telCelularEdit;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}
	public Boolean getEndValido() {
		return endValido;
	}

	public void setEndValido(Boolean endValido) {
		this.endValido = endValido;
	}

	public Boolean getNumValido() {
		return numValido;
	}

	public void setNumValido(Boolean numValido) {
		this.numValido = numValido;
	}

	public Boolean getCompValido() {
		return compValido;
	}

	public void setCompValido(Boolean compValido) {
		this.compValido = compValido;
	}

	public Boolean getBairroValido() {
		return bairroValido;
	}

	public void setBairroValido(Boolean bairroValido) {
		this.bairroValido = bairroValido;
	}

	public Boolean getCidadeValido() {
		return cidadeValido;
	}

	public void setCidadeValido(Boolean cidadeValido) {
		this.cidadeValido = cidadeValido;
	}

	public Boolean getEstadoValido() {
		return estadoValido;
	}

	public void setEstadoValido(Boolean estadoValido) {
		this.estadoValido = estadoValido;
	}

	public Boolean getPaisValido() {
		return paisValido;
	}

	public void setPaisValido(Boolean paisValido) {
		this.paisValido = paisValido;
	}

	public Boolean getInfValido() {
		return infValido;
	}

	public void setInfValido(Boolean infValido) {
		this.infValido = infValido;
	}

	public Boolean getCepValido() {
		return cepValido;
	}

	public void setCepValido(Boolean cepValido) {
		this.cepValido = cepValido;
	}
	public Boolean getTipoValido() {
		return tipoValido;
	}

	public void setTipoValido(Boolean tipoValido) {
		this.tipoValido = tipoValido;
	}

	public EnderecoVo getEnderecoIns() {
		return enderecoIns;
	}

	public void setEnderecoIns(EnderecoVo enderecoIns) {
		this.enderecoIns = enderecoIns;
	}
	
	public EnderecoVo getEnderecoEdit() {
		return enderecoEdit;
	}

	public void setEnderecoEdit(EnderecoVo enderecoEdit) {
		this.enderecoEdit = enderecoEdit;
	}
	

	public String inserir(){
		int cpfExist = 0;
		boolean insere = true;

		validaUsuario(usuVo, telResidencial);
		LoginVo login = new LoginVo();
		if(apelidoValido && nomeValido && sobrenomeValido && dataNascValido && cpfValido &&
				telefoneValido && emailValido && senhaValido && confirmValido && endValido && 
				cepValido && numValido && cidadeValido && estadoValido && bairroValido){

			usuVo.setCpf(usuVo.getCpf().replaceAll("-",""));
			usuVo.setCpf(usuVo.getCpf().replace(".",""));

			if(usuVo.getIdPerfil() == null || usuVo.getIdPerfil() <= 0){
				usuVo.setIdPerfil(1);
			}
			usuVo.setAtivo('S');
			usuVo.setEspecial('N');

			cpfExist = new UsuarioDao().getCPF(usuVo.getCpf(), 0);
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
					enderecoIns.setId(idUsuario);
					inserirEnd(enderecoIns);
					setErroSubmit("Cadastro efetuado com sucesso!");
					login.setEmail(usuVo.getEmail());
					login.setSenha(usuVo.getSenha());
					new LoginBo().loginCad(login);
					return "inn001";

				}
			}
		}
		telCelular = new TelefoneVo();
		telComercial = new TelefoneVo();
		return "inn003return";
	}


	public String buscaUsuario(){
		ArrayList<TelefoneVo> telUser = new ArrayList<TelefoneVo>();
		usuEdit = new UsuarioDao().getUsuarioById(idUsuario);
		telUser = buscaTelefone(idUsuario);
		enderecoEdit = new EnderecoDao().getEndByUser(usuEdit.getId());

		for (TelefoneVo telefoneVo : telUser){

			if(telefoneVo.getIdTipoTelefone() == TipoTelefoneEnum.CELULAR.ordinal()+1){
				telCelularEdit.setDdd(telefoneVo.getDdd());
				telCelularEdit.setId(telefoneVo.getId());
				telCelularEdit.setIdTipoTelefone(telefoneVo.getIdTipoTelefone());
				telCelularEdit.setIdUsuario(telefoneVo.getIdUsuario());
				telCelularEdit.setNumero(telefoneVo.getNumero());

			}else if(telefoneVo.getIdTipoTelefone() == TipoTelefoneEnum.COMERCIAL.ordinal()+1){
				telComercialEdit.setDdd(telefoneVo.getDdd());
				telComercialEdit.setId(telefoneVo.getId());
				telComercialEdit.setIdTipoTelefone(telefoneVo.getIdTipoTelefone());
				telComercialEdit.setIdUsuario(telefoneVo.getIdUsuario());
				telComercialEdit.setNumero(telefoneVo.getNumero());

			}else if(telefoneVo.getIdTipoTelefone() == TipoTelefoneEnum.RESIDENCIAL.ordinal()+1){
				telResidencialEdit.setDdd(telefoneVo.getDdd());
				telResidencialEdit.setId(telefoneVo.getId());
				telResidencialEdit.setIdTipoTelefone(telefoneVo.getIdTipoTelefone());
				telResidencialEdit.setIdUsuario(telefoneVo.getIdUsuario());
				telResidencialEdit.setNumero(telefoneVo.getNumero());

			}
		}

		return "inn003Edit";
	}

	public ArrayList<TelefoneVo> buscaTelefone(Integer id){

		ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();
		telAl = new TelefoneDao().getTelefoneByUser(id);
		return telAl;
	}


	public void editar(){
		int cpfExist = 0;
		boolean insere = true;
		int count = 0;
		validaUsuario(usuEdit, telResidencialEdit);

		if(apelidoValido && nomeValido && sobrenomeValido && dataNascValido && cpfValido &&
				telefoneValido && emailValido && senhaValido && confirmValido){

		}
		usuEdit.setCpf(usuEdit.getCpf().replaceAll("-",""));
		usuEdit.setCpf(usuEdit.getCpf().replace(".",""));

		cpfExist = new UsuarioDao().getCPF(usuEdit.getCpf(), usuEdit.getId());
		if(cpfExist > 0){
			setErroSubmit("CPF já cadastrado!");
			insere = false;
		}

		if(usuEdit.getSenha() != null && !usuEdit.getSenha().equals("")){
			insere = editarSenha(usuEdit.getId());
		}


		if(insere){
			count = new UsuarioDao().edit(usuEdit);
			if(count > 0){
				inserirTel(idUsuario);
				setErroSubmit("Informações editadas com sucesso!");
			}
		}



	}

	private boolean editarSenha(Integer id){
		String senhaAtual;

		senhaAtual = new UsuarioDao().getSenhaAtual(id);
		if(senhaAtual.equals(usuEdit.getSenha())){
			if(usuEdit.getSenhaNova().equals(usuEdit.getConfirmaSenha())){
				return true;
			}else{
				setErroSubmit("As senhas estão diferentes!");
			}
		}else{
			setErroSubmit("As senha atual está incorreta!");
		}
		return false;
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

	public int inserirEnd(EnderecoVo endVo){
		
		int countIns = 0;
		int cidadeId = 0;
		int estadoId = 0;

		cidadeId = new EnderecoDao().getCidade(endVo.getNomeCidade());
		estadoId = EstadoEnum.getIdEstado(endVo.getUf());

		if(cidadeId == 0){
			cidadeId = new EnderecoDao().insertCidade(endVo.getNomeCidade(), estadoId);
		}

		endVo.setIdCidade(cidadeId);
		endVo.setIdEstado(estadoId);
		endVo.setIdUsuario(idUsuario);
		countIns = new EnderecoDao().insertEndereco(endVo);
		return countIns;
	}

	public String buscaEmail(){
		String existeEmail = "";

		if(email == null || email.equals("")){
			setErroSubmit("Digite seu email");
			emailValido = false;
		}else{
			existeEmail = new UsuarioDao().getEmailExist(email);
			if(existeEmail != null && !existeEmail.equals("")){
				emailValido = false;
			}else{
				usuVo.setEmail(email);
			}
		}

		if(cep == null || cep.equals("")){
			setErroSubmit("Digite seu cep");
			cepValido = false;
		}else{
			buscarEndereco(cep);
		}

		if(cepValido && emailValido){
			return "inn003return";
		}
		return null;		
	}
	
	private void buscarEndereco(String cep){
		try{
			enderecoIns = new CorreiosService().consultarEndereco(cep);
			if(enderecoIns.getLogradouro() == null || enderecoIns.getLogradouro().equals("")){
				cepValido = false;
			}
		}catch(Exception e){
			enderecoIns = new EnderecoVo();
		}
	}
		
	
	public String buscarCep(){
		buscarEndereco(enderecoIns.getCep());
		return null;
	}


	//validações
	public  void validaUsuario( UsuarioVo usu, TelefoneVo tel){
		if(usu.getApelido().equals(null) || usu.getApelido().equals("")){
			apelidoValido = false;
		}

		if(usu.getNome().equals(null) || usu.getNome().equals("")){
			nomeValido = false;
		}
		if(usu.getSobrenome().equals(null) || usu.getSobrenome().equals("")){
			sobrenomeValido = false;

		}

		if(usu.getCpf() == null || usu.getCpf().equals("")){
			cpfValido = false;

		}

		if(usu.getEmail().equals(null) || usu.getEmail().equals("")){
			emailValido = false;
		}


		if(tel.getDdd() == null || tel.getDdd() <= 0
				|| tel.getNumero().equals(null) || tel .getNumero() <= 0 ){
			telValido = false;
			tel.setDdd(null);
			tel.setNumero(null);
			
		}

		if(enderecoIns.getLogradouro() == null || enderecoIns.getLogradouro().equals("")){
			endValido = false;
		}

		if(enderecoIns.getNumero() == null || enderecoIns.getNumero().equals("")){
			numValido = false;
			enderecoIns.setNumero(null);
		}

		if(enderecoIns.getBairro() == null || enderecoIns.getBairro().equals("")){
			bairroValido = false;
		}

		if(enderecoIns.getNomeCidade() == null || enderecoIns.getNomeCidade().equals("")){
			cidadeValido  = false;
		}

		if(enderecoIns.getNomeEstado() == null || enderecoIns.getNomeEstado().equals("")){
			estadoValido = false;
		}

	}
}