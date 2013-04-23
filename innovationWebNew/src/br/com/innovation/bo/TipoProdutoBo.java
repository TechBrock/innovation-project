package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.innovation.dao.PerfilDao;
import br.com.innovation.dao.TipoProdutoDao;
import br.com.innovation.utils.MessagesUtil;
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


	public String inserir(){
		int count = 0;
		if(nome.equals(null) || nome.equals("")){
			MessagesUtil.exibeMensagemAlerta("Preencha o campo Nome!");
		}else{
			count = new TipoProdutoDao().insertTipoProduto(nome);
			if(count > 0){
				MessagesUtil.exibeMensagemInf("Tipo de Produto inserido com sucesso!");
			}
		}
		return "inn006return";
	}

	public String editar(){
		int count = 0;
		if(tipoEdit.getNome().equals(null) || tipoEdit.getNome().equals("")){
			MessagesUtil.exibeMensagemAlerta("Preencha o campo Nome!");
		}else{
			count = new TipoProdutoDao().editTipoProduto(tipoEdit);
			if(count > 0){
				MessagesUtil.exibeMensagemInf("Tipo de Produto editado com sucesso!");
			}
		}
		return "inn006return";

	}

	public String buscar(){
		if(tipoVo.getId() == null || tipoVo.getId() <= 0
				&& tipoVo.getNome().equals(null) || tipoVo.getNome().equals("")){
			MessagesUtil.exibeMensagemAlerta("Preencha um campo para pesquisa!");
		}else{
			tipoProdutoAl = new TipoProdutoDao().getTipoProduto(tipoVo);

			if(tipoProdutoAl.size() <=0){
				MessagesUtil.exibeMensagemInf("Não há resultado para sua pesquisa");
			}
		}
		return null;
	}
	
	public String deletar(){
		int count = 0;
		count = new PerfilDao().deletePerfil(id);
		if(count > 0){
			MessagesUtil.exibeMensagemInf("Tipo de produto deletado com sucesso!");
		}
		return "inn006return";
	}
}
