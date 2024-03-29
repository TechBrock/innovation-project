package br.com.innovation.vo;

import java.io.Serializable;

public class FavoritoVo implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7662150316733122398L;
	private Integer id;
	private Integer idUsuario;
	private Integer idModelo;
	private String nomeModelo;
	private String nomeCor;
	private String nomeClassificacao;
	private String img1Modelo;
	private Double preco;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getIdModelo() {
		return idModelo;
	}
	public void setIdModelo(Integer idModelo) {
		this.idModelo = idModelo;
	}
	public String getNomeModelo() {
		return nomeModelo;
	}
	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	public String getNomeCor() {
		return nomeCor;
	}
	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}
	public String getNomeClassificacao() {
		return nomeClassificacao;
	}
	public void setNomeClassificacao(String nomeClassificacao) {
		this.nomeClassificacao = nomeClassificacao;
	}
	
	
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getImg1Modelo() {
		return img1Modelo;
	}
	public void setImg1Modelo(String img1Modelo) {
		this.img1Modelo = img1Modelo;
	}
	
}
