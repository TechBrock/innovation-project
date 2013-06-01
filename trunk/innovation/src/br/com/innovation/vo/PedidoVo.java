package br.com.innovation.vo;

import java.io.Serializable;
import java.util.Date;

public class PedidoVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8195697472249803967L;
	private Integer id;
	private Integer ordemCompra;
	private Date dataPedido;
	private Double valorCompra;
	private Double valorFrete;
	private Double valorTotal;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getOrdemCompra() {
		return ordemCompra;
	}
	public void setOrdemCompra(Integer ordemCompra) {
		this.ordemCompra = ordemCompra;
	}
	public Date getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
