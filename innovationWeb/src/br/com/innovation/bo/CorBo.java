package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.innovation.dao.ClassificacaoDao;
import br.com.innovation.dao.CorDao;
import br.com.innovation.utils.MessagesUtil;
import br.com.innovation.vo.CorVo;

public class CorBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6843362817852151940L;

	private String nome;
	private CorVo corVo = new CorVo();
	private CorVo corEdit = new CorVo();
	private ArrayList<CorVo> corAl = new ArrayList<CorVo>();
	private Integer id;
	private String erroSubmit;
	private boolean descValida = true;
	private boolean pesqValida = true;
	private List<SelectItem>corSelect = new ArrayList<SelectItem>();


	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public CorVo getCorVo() {
		return corVo;
	}
	public void setCorVo(CorVo corVo) {
		this.corVo = corVo;
	}
	public ArrayList<CorVo> getCorAl() {
		return corAl;
	}
	public void setCorAl(ArrayList<CorVo> corAl) {
		this.corAl = corAl;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getErroSubmit() {
		return erroSubmit;
	}
	public void setErroSubmit(String erroSubmit) {
		this.erroSubmit = erroSubmit;
	}
	public boolean isDescValida() {
		return descValida;
	}
	public void setDescValida(boolean descValida) {
		this.descValida = descValida;
	}
	public CorVo getCorEdit() {
		return corEdit;
	}
	public void setCorEdit(CorVo corEdit) {
		this.corEdit = corEdit;
	}
	public boolean isPesqValida() {
		return pesqValida;
	}
	public void setPesqValida(boolean pesqValida) {
		this.pesqValida = pesqValida;
	}
	public List<SelectItem> getCorSelect() {
		return corSelect;
	}
	public void setCorSelect(List<SelectItem> corSelect) {
		this.corSelect = corSelect;
	}
	
	
	public String inserir(){
		int count = 0;

		if(nome == null || nome.equals("")){
			descValida = false;
		}else{
			count = new CorDao().insertCor(nome);
			if(count > 0){
				erroSubmit = "Cor inserida com sucesso!";
				return "inn008return";
			}
		}
		return null;
	}

	public String editar(){
		int count = 0;

		if(nome == null || nome.equals("")){
			descValida = false;
		}else{
			count = new CorDao().edtitCor(corEdit);
			if(count > 0){
				erroSubmit = "Cor editada com sucesso!";
				return "inn008return";
			}
		}
		return null;
	}

	public String deletar(){
		int count = 0;
		count = new CorDao().deleteCor(id);
		if(count > 0){
			MessagesUtil.exibeMensagemInf("Cor deletada com sucesso!");
			buscar();
		}
		return "inn008return";
	}

	public String buscar(){
		if(corVo.getId() == null || corVo.getId() <= 0
				&& corVo.getNome().equals(null) || corVo.getNome().equals("")){
			pesqValida = false;
		}else{
			corAl = new CorDao().getCor(corVo);

			if(corAl.size() <=0){
				erroSubmit = "Não há resultado para sua pesquisa";
				return "inn008return";
			}
		}

		return null;
	}
	
	public List<SelectItem> getCorItem(){
		return corSelect = new CorDao().getCorSelect();
	}

}
