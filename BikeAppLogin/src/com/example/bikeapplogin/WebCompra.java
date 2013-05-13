package com.example.bikeapplogin;
import java.util.Date;


public class WebCompra {
	
	private int id;
	private int ordemCompra;
	private int qtdParcelas;
	private double Desconto;
	private double valorFrete;
	private double valorCompra;
	private int prazo;
	private char aprovado;
	private Date dataPedido;
	private Date dataEntrega;
	private int idMeioPagamento;
	private int idTipoFrete;
	private int idjuros;
	private int idEndereco;
	private int idUsusario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdemCompra() {
		return ordemCompra;
	}
	public void setOrdemCompra(int ordemCompra) {
		this.ordemCompra = ordemCompra;
	}
	public int getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(int qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public double getDesconto() {
		return Desconto;
	}
	public void setDesconto(double desconto) {
		Desconto = desconto;
	}
	public double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public int getPrazo() {
		return prazo;
	}
	public void setPrazo(int prazo) {
		this.prazo = prazo;
	}
	public char getAprovado() {
		return aprovado;
	}
	public void setAprovado(char aprovado) {
		this.aprovado = aprovado;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public int getIdMeioPagamento() {
		return idMeioPagamento;
	}
	public void setIdMeioPagamento(int idMeioPagamento) {
		this.idMeioPagamento = idMeioPagamento;
	}
	public int getIdTipoFrete() {
		return idTipoFrete;
	}
	public void setIdTipoFrete(int idTipoFrete) {
		this.idTipoFrete = idTipoFrete;
	}
	public int getIdjuros() {
		return idjuros;
	}
	public void setIdjuros(int idjuros) {
		this.idjuros = idjuros;
	}
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public int getIdUsusario() {
		return idUsusario;
	}
	public void setIdUsusario(int idUsusario) {
		this.idUsusario = idUsusario;
	}

}
