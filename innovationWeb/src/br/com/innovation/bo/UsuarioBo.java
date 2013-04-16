package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;

import com.sun.xml.internal.bind.unmarshaller.Messages;

import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.enums.PerfilEnum;
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
	TelefoneVo telResidencial = new TelefoneVo();
	TelefoneVo telComercial = new TelefoneVo();
	TelefoneVo telCelular = new TelefoneVo();

	//Arrays
	ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();
	
	//Atributo
	private String diaNasc;
	private String mesNasc;
	private String anoNasc;
	private int idUsuario = 0;
	
	
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

	public void inserir(){
		
		usuVo.setDataNascimento(anoNasc+"-"+mesNasc+"-"+diaNasc);
		usuVo.setSexo('F');
		usuVo.setAtivo('S');
		usuVo.setReceberEmail('S');
		usuVo.setEspecial('N');
		usuVo.setIdPerfil(PerfilEnum.CLIENTE.ordinal()+1);
		
		idUsuario = new UsuarioDao().insertUsuario(usuVo);
		if(idUsuario > 0){
			inserirTel(idUsuario);
		}
	}
		
		
		private void inserirTel(int idUsuario){
			if(telResidencial.getDdd() != null){
				telResidencial.setIdUsuario(idUsuario);
				telResidencial.setIdTipoTelefone(TipoTelefoneEnum.RESIDENCIAL.ordinal()+1);
				new TelefoneDao().insertUsuario(telResidencial);
			}
			
			if(telResidencial.getDdd() != null){
				telResidencial.setIdUsuario(idUsuario);
				telResidencial.setIdTipoTelefone(TipoTelefoneEnum.RESIDENCIAL.ordinal()+1);
				new TelefoneDao().insertUsuario(telResidencial);
			}
			
			if(telComercial.getDdd() != null){
				telComercial.setIdUsuario(idUsuario);
				telComercial.setIdTipoTelefone(TipoTelefoneEnum.COMERCIAL.ordinal()+1);
				new TelefoneDao().insertUsuario(telComercial);
			}
			
			if(telCelular.getDdd() != null){
				telCelular.setIdUsuario(idUsuario);
				telCelular.setIdTipoTelefone(TipoTelefoneEnum.CELULAR.ordinal()+1);
				new TelefoneDao().insertUsuario(telCelular);
			}
		}
		
	//validações
		public  void validaApelido(){
			if(usuVo.getApelido().equals(null) || usuVo.getApelido().equals("")){
				MessagesUtil.exibeMensagemErro("Apelido obrigatório", "validaApelido");
			}
		}
		
		

}
