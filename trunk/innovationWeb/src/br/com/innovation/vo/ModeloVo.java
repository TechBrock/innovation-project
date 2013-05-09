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
	private Double garantia;
	private String material;
	private Integer idClassificacao;
	private Integer idCor;
	private Integer idTipo;
	private byte[] img1;
	private byte[] img2;
	private byte[] img3;
	private byte[] img4;
	
	
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
	public Double getGarantia() {
		return garantia;
	}
	public void setGarantia(Double garantia) {
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
	public byte[] getImg1() {
		return img1;
	}
	public void setImg1(byte[] img1) {
		this.img1 = img1;
	}
	public byte[] getImg2() {
		return img2;
	}
	public void setImg2(byte[] img2) {
		this.img2 = img2;
	}
	public byte[] getImg3() {
		return img3;
	}
	public void setImg3(byte[] img3) {
		this.img3 = img3;
	}
	public byte[] getImg4() {
		return img4;
	}
	public void setImg4(byte[] img4) {
		this.img4 = img4;
	}
	
	
}
