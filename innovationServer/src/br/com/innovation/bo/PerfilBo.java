package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.innovation.dao.PerfilDao;
import br.com.innovation.utils.MessagesUtil;
import br.com.innovation.vo.PerfilVo;

public class PerfilBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1766114382514865603L;
	private PerfilVo perfilVo = new PerfilVo();
	private PerfilVo perfilEdit = new PerfilVo();
	private ArrayList<PerfilVo> perfilAl = new ArrayList<PerfilVo>();
	private List<SelectItem>perfilSelect = new ArrayList<SelectItem>();
	private String descInsert;
	private Integer idDelete;
	private boolean perfilValido = true;
	private String erroSubmit;

	public PerfilVo getPerfilVo() {
		return perfilVo;
	}
	public void setPerfilVo(PerfilVo perfilVo) {
		this.perfilVo = perfilVo;
	}

	public PerfilVo getPerfilEdit() {
		return perfilEdit;
	}
	public void setPerfilEdit(PerfilVo perfilEdit) {
		this.perfilEdit = perfilEdit;
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

	public Integer getIdDelete() {
		return idDelete;
	}
	public void setIdDelete(Integer idDelete) {
		this.idDelete = idDelete;
	}

	public boolean isPerfilValido() {
		return perfilValido;
	}
	public void setPerfilValido(boolean perfilValido) {
		this.perfilValido = perfilValido;
	}
	

	public String getErroSubmit() {
		return erroSubmit;
	}
	public void setErroSubmit(String erroSubmit) {
		this.erroSubmit = erroSubmit;
	}
	public String inserir(){
		int countInsert = 0;
		if(descInsert == null || descInsert.equals("")){
			perfilValido = false;
		}else{
			countInsert = new PerfilDao().insertPerfil(descInsert);
			if(countInsert > 0){
				erroSubmit = "Perfil inserido com sucesso!";
				buscar();
				return "inn005return";
			}
		}
		return null;

		
	}

	public String editar(){
		int count  = 0;
		if(perfilEdit.getDescricao() == null || perfilEdit.getDescricao().equals("")){
			perfilValido = false;
		}else{
			count = new PerfilDao().editPerfil(perfilEdit);
			if(count > 0){
				erroSubmit = "Perfil editado com sucesso!";
				buscar();
				return "inn005return";
			}
		}
		return null;
		
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

	public String deletar(){
		int count = 0;
		count = new PerfilDao().deletePerfil(idDelete);
		if(count > 0){
			MessagesUtil.exibeMensagemInf("Perfil deletado com sucesso!");
			buscar();
		}
		return "inn005return";
	}

	public List<SelectItem> getPerfilSelectItem(){
		return perfilSelect = new PerfilDao().getPerfilSelect();
	}


}
