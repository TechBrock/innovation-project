package br.com.innovation.vo;

import java.io.Serializable;

public class PerfilVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7359350095171125868L;
	
	private Integer id;
	private String descricao;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
