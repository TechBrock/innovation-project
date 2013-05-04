package br.com.innovation.vo;

import java.io.Serializable;

public class ModeloVo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9117173534286971709L;
	private Integer id;
	private String nome;
	private Integer quantidade;
	private String caract;
	private Double tamanho;
	private String dimensao;
	private Double peso;
	private Integer aro;
	private String infAdc;
	private String garantia;
	private String material;
	private Integer idClassificacao;
	private Integer idCor;
	private Integer idTipo;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	
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
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public String getCaract() {
		return caract;
	}
	public void setCaract(String caract) {
		this.caract = caract;
	}
	public Double getTamanho() {
		return tamanho;
	}
	public void setTamanho(Double tamanho) {
		this.tamanho = tamanho;
	}
	public String getDimensao() {
		return dimensao;
	}
	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Integer getAro() {
		return aro;
	}
	public void setAro(Integer aro) {
		this.aro = aro;
	}
	public String getInfAdc() {
		return infAdc;
	}
	public void setInfAdc(String infAdc) {
		this.infAdc = infAdc;
	}
	public String getGarantia() {
		return garantia;
	}
	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public Integer getIdClassificacao() {
		return idClassificacao;
	}
	public void setIdClassificacao(Integer idClassificacao) {
		this.idClassificacao = idClassificacao;
	}
	public Integer getIdCor() {
		return idCor;
	}
	public void setIdCor(Integer idCor) {
		this.idCor = idCor;
	}
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
}
