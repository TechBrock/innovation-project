package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.innovation.dao.PerfilDao;
import br.com.innovation.dao.TipoProdutoDao;
import br.com.innovation.vo.TipoProdutoVo;

public class TipoProdutoBo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -549416800466144345L;
	private String nome;
	private Integer id;
	private TipoProdutoVo tipoEdit = new TipoProdutoVo();
	private TipoProdutoVo tipoVo = new TipoProdutoVo();
	private ArrayList<TipoProdutoVo> tipoProdutoAl = new ArrayList<TipoProdutoVo>();
	private String erroSubmit;
	private boolean descValida = true;
	private List<SelectItem>tipoProdutoSelect = new ArrayList<SelectItem>();

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TipoProdutoVo getTipoEdit() {
		return tipoEdit;
	}
	public void setTipoEdit(TipoProdutoVo tipoEdit) {
		this.tipoEdit = tipoEdit;
	}

	public TipoProdutoVo getTipoVo() {
		return tipoVo;
	}
	public void setTipoVo(TipoProdutoVo tipoVo) {
		this.tipoVo = tipoVo;
	}
	public ArrayList<TipoProdutoVo> getTipoProdutoAl() {
		return tipoProdutoAl;
	}
	public void setTipoProdutoAl(ArrayList<TipoProdutoVo> tipoProdutoAl) {
		this.tipoProdutoAl = tipoProdutoAl;
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
	
	public List<SelectItem> getTipoProdutoSelect() {
		return tipoProdutoSelect;
	}
	public void setTipoProdutoSelect(List<SelectItem> tipoProdutoSelect) {
		this.tipoProdutoSelect = tipoProdutoSelect;
	}
	
	
	public String inserir(){
		int count = 0;
		if(nome == null || nome.equals("")){
			descValida = false;
			
		}else{
			count = new TipoProdutoDao().insertTipoProduto(nome);
			if(count > 0){
				erroSubmit = "Tipo de Produto inserido com sucesso!";
				buscar();
				return "inn006return";
			}
		}
		return null;
	}

	public String editar(){
		int count = 0;
		if(tipoEdit.getNome() == null || tipoEdit.getNome().equals("")){
			descValida = false;
		}else{
			count = new TipoProdutoDao().editTipoProduto(tipoEdit);
			if(count > 0){
				erroSubmit = "Tipo de Produto editado com sucesso!";
				buscar();
			}
			return "inn006return";
		}
		return null;
		

	}

	public String buscar(){
		if(tipoVo.getId() == null || tipoVo.getId() <= 0
				&& tipoVo.getNome().equals(null) || tipoVo.getNome().equals("")){
			descValida = false;
		}else{
			tipoProdutoAl = new TipoProdutoDao().getTipoProduto(tipoVo);

			if(tipoProdutoAl.size() <=0){
				erroSubmit = "Não há resultado para sua pesquisa";
			}
		}
		return null;
	}
	
	public String deletar(){
		int count = 0;
		count = new PerfilDao().deletePerfil(id);
		if(count > 0){
			erroSubmit = "Tipo de produto deletado com sucesso!";
			buscar();
		}
		return "inn006return";
	}
	
	public List<SelectItem> getTipoProdutoSelectItem(){
		return tipoProdutoSelect = new TipoProdutoDao().getTipoProdutoSelect();
	}
}
