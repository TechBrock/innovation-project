package br.com.vo;

import java.io.Serializable;

public class TelefoneVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2832648247843664469L;
	
	private Integer id;
	private Integer ddd;
	private Integer numero;
	private Integer idUsuario;
	private Integer IdTipoTelefone;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdTipoTelefone() {
		return IdTipoTelefone;
	}
	public void setIdTipoTelefone(Integer idTipoTelefone) {
		IdTipoTelefone = idTipoTelefone;
	}
}
