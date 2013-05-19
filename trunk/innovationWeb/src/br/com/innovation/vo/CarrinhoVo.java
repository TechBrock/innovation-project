package br.com.innovation.vo;

import java.io.Serializable;

public class CarrinhoVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8000459096647618646L;
	private Integer idModelo;
	private Integer qtdModelo;
	private Integer imgModelo;
	private Integer precoModelo;
	private Integer idUsuario;
	
	public Integer getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	public Integer getQtdModelo() {
		return qtdModelo;
	}
	public void setQtdModelo(Integer qtdModelo) {
		this.qtdModelo = qtdModelo;
	}
	public Integer getImgModelo() {
		return imgModelo;
	}
	public void setImgModelo(Integer imgModelo) {
		this.imgModelo = imgModelo;
	}
	public Integer getPrecoModelo() {
		return precoModelo;
	}
	public void setPrecoModelo(Integer precoModelo) {
		this.precoModelo = precoModelo;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
}
