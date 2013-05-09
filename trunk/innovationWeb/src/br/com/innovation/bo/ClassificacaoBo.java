package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.com.innovation.dao.ClassificacaoDao;
import br.com.innovation.dao.TipoProdutoDao;
import br.com.innovation.vo.ClassificacaoVo;

public class ClassificacaoBo implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -9031828866001111738L;
	private String nome;
	private ClassificacaoVo classVo = new ClassificacaoVo();
	private ClassificacaoVo classEdit = new ClassificacaoVo();
	private ArrayList<ClassificacaoVo> classAl = new ArrayList<ClassificacaoVo>();
	private Integer id;
	private String erroSubmit;
	private boolean descValida = true;
	private boolean pesqValida = true;
	private List<SelectItem>classSelect = new ArrayList<SelectItem>();



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ClassificacaoVo getClassVo() {
		return classVo;
	}
	public void setClassVo(ClassificacaoVo classVo) {
		this.classVo = classVo;
	}
	public ClassificacaoVo getClassEdit() {
		return classEdit;
	}
	public void setClassEdit(ClassificacaoVo classEdit) {
		this.classEdit = classEdit;
	}
	public ArrayList<ClassificacaoVo> getClassAl() {
		return classAl;
	}
	public void setClassAl(ArrayList<ClassificacaoVo> classAl) {
		this.classAl = classAl;
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
	public boolean isPesqValida() {
		return pesqValida;
	}
	public void setPesqValida(boolean pesqValida) {
		this.pesqValida = pesqValida;
	}
	public List<SelectItem> getClassSelect() {
		return classSelect;
	}
	public void setClassSelect(List<SelectItem> classSelect) {
		this.classSelect = classSelect;
	}
	
	
	public String inserir(){
		int count = 0;

		if(nome == null || nome.equals("")){
			descValida = false;
		}else{
			count = new ClassificacaoDao().insertClass(nome);
			if(count > 0){
				erroSubmit = "Classificação inserida com sucesso!";
				nome ="";
				return "inn009return";
			}
		}
		return null;
	}

	public String editar(){
		int count = 0;

		if(classEdit.getNome() == null || classEdit.getNome().equals("")){
			descValida = false;
		}else{
			count = new ClassificacaoDao().edtitClass(classEdit);
			if(count > 0){
				erroSubmit = "Classificação editada com sucesso!";
				nome = null;
				return "inn009return";
			}
		}
		return null;
	}

	public String deletar(){
		int count = 0;
		count = new ClassificacaoDao().deleteClas(id);
		if(count > 0){
			erroSubmit = "Classificação deletada com sucesso!";
			buscar();
		}
		return "inn009return";
	}

	public String buscar(){
		if(classVo.getId() == null || classVo.getId() <= 0
				&& classVo.getNome().equals(null) || classVo.getNome().equals("")){
			pesqValida = false;
		}else{
			classAl = new ClassificacaoDao().getClass(classVo);

			if(classAl.size() <=0){
				erroSubmit = "Não há resultado para sua pesquisa";
				return "inn009return";
			}
		}

		return null;
	}
	
	public List<SelectItem> getTipoProdutoSelectItem(){
		return classSelect = new ClassificacaoDao().getClassificacaoSelect();
	}

}
