package br.com.innovation.vo;

import java.io.Serializable;

public class CorVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2181903370221672800L;
	private Integer id;
	private String nome;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
