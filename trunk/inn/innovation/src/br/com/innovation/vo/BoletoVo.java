package br.com.innovation.vo;

import java.io.Serializable;
import java.util.Date;

public class BoletoVo implements Serializable{
	private int id;
	private Date dataProcessamento;
	private Date dataDocumento;
	private Date dataVencimento;
	private int idCliente;
	private int idCompra;
	private double valorBoleto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDataProcessamento() {
		return dataProcessamento;
	}
	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}
	public Date getDataDocumento() {
		return dataDocumento;
	}
	public void setDataDocumento(Date dataDocumento) {
		this.dataDocumento = dataDocumento;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public double getValorBoleto() {
		return valorBoleto;
	}
	public void setValorBoleto(double valorBoleto) {
		this.valorBoleto = valorBoleto;
	}
	public int getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	
	
	
	
}
