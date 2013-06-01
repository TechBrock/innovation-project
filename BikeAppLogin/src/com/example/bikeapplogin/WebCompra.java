package com.example.bikeapplogin;
import java.util.Date;


public class WebCompra {
	
	private int id;
	private int ordemCompra;
	private int qtdParcelas;
	private double valorFrete;
	private double valorCompra;
	private int prazo;
	private Date dataPedido;
	private Date dataEntrega;
	private String meioPagamento;
	private String tipoFrete;
	
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
	public String getMeioPagamento() {
		return meioPagamento;
	}
	public void setMeioPagamento(String meioPagamento) {
		this.meioPagamento = meioPagamento;
	}
	public String getTipoFrete() {
		return tipoFrete;
	}
	public void setTipoFrete(String tipoFrete) {
		this.tipoFrete = tipoFrete;
	}
	
}
