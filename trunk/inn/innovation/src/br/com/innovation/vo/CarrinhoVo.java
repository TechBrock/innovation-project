package br.com.innovation.vo;

import java.io.Serializable;

public class CarrinhoVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8000459096647618646L;
	private Integer idModelo;
	private String nomeModelo;
	private Integer qtdModelo = 0;
	private Integer imgModelo;
	private Double precoModelo = 0.0;
	private Double valorTotal;
	private Double valorCarrinho = 0.0;
	private Integer idUsuario;
	private Integer idTipoItem;
	
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
	public Double getPrecoModelo() {
		return precoModelo;
	}
	public void setPrecoModelo(Double  precoModelo) {
		this.precoModelo = precoModelo;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeModelo() {
		return nomeModelo;
	}
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	public Double getValorCarrinho() {
		return valorCarrinho;
	}
	public void setValorCarrinho(Double valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}
	public Integer getIdTipoItem() {
		return idTipoItem;
	}
	public void setIdTipoItem(Integer idTipoItem) {
		this.idTipoItem = idTipoItem;
	}
}
