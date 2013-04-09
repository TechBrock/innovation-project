package br.com.innovation.vo;

import java.io.Serializable;

public class CidadeVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1444174319732338883L;
	private Integer id;
	private Integer idEstado;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
