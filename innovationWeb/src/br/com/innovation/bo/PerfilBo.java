package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.innovation.dao.PerfilDao;
import br.com.innovation.utils.MessagesUtil;
import br.com.innovation.vo.PerfilVo;

public class PerfilBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1766114382514865603L;
	private PerfilVo perfilVo = new PerfilVo();
	private ArrayList<PerfilVo> perfilAl = new ArrayList<PerfilVo>();
	private String descInsert;

	public PerfilVo getPerfilVo() {
		return perfilVo;
	}
	public void setPerfilVo(PerfilVo perfilVo) {
		this.perfilVo = perfilVo;
	}
	public ArrayList<PerfilVo> getPerfilAl() {
		return perfilAl;
	}
	public void setPerfilAl(ArrayList<PerfilVo> perfilAl) {
		this.perfilAl = perfilAl;
	}

	public String getDescInsert() {
		return descInsert;
	}
	public void setDescInsert(String descInsert) {
		this.descInsert = descInsert;
	}
	public String inserir(){
		int countInsert = 0;
		countInsert = new PerfilDao().insertPerfil(descInsert);
		if(countInsert > 0){
			MessagesUtil.exibeMensagemInf("Perfil inserido com sucesso!");
		}

		return "inn005return";
	}

	public String buscar(){
		if(perfilVo.getId() == null || perfilVo.getId() <= 0
				&& perfilVo.getDescricao().equals(null) || perfilVo.getDescricao().equals("")){
			MessagesUtil.exibeMensagemAlerta("Preencha um campo para pesquisa!");
		}else{
			perfilAl = new PerfilDao().getPerfil(perfilVo);

			if(perfilAl.size() <=0){
				MessagesUtil.exibeMensagemInf("Não há resultado para sua pesquisa");
			}
		}

		return null;
	}
}
