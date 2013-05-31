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
	private String img1Caminho;
	private String img2Caminho;
	private String img3Caminho;
	private String img4Caminho;
	private Double precoAtual;
	private Double precoMaior;
	private String nomeCor;
	private String nomeClassificacao;
	
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
	public String getImg1Caminho() {
		return img1Caminho;
	}
	public void setImg1Caminho(String img1Caminho) {
		this.img1Caminho = img1Caminho;
	}
	public String getImg2Caminho() {
		return img2Caminho;
	}
	public void setImg2Caminho(String img2Caminho) {
		this.img2Caminho = img2Caminho;
	}
	public String getImg3Caminho() {
		return img3Caminho;
	}
	public void setImg3Caminho(String img3Caminho) {
		this.img3Caminho = img3Caminho;
	}
	public String getImg4Caminho() {
		return img4Caminho;
	}
	public void setImg4Caminho(String img4Caminho) {
		this.img4Caminho = img4Caminho;
	}
	public Double getPrecoAtual() {
		return precoAtual;
	}
	public void setPrecoAtual(Double precoAtual) {
		this.precoAtual = precoAtual;
	}
	public Double getPrecoMaior() {
		return precoMaior;
	}
	public void setPrecoMaior(Double precoMaior) {
		this.precoMaior = precoMaior;
	}
	public String getNomeCor() {
		return nomeCor;
	}
	public void setNomeCor(String nomeCor) {
		this.nomeCor = nomeCor;
	}
	public String getNomeClassificacao() {
		return nomeClassificacao;
	}
	public void setNomeClassificacao(String nomeClassificacao) {
		this.nomeClassificacao = nomeClassificacao;
	}
	
}
