package br.com.innovation.vo;

import java.io.Serializable;
import java.sql.Date;

public class CompraVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4685974625721341515L;
	private Integer id;
	private Integer idCompra;
	private Integer qtdParcelas;
	private Double desconto;
	private Double valorFrete;
	private Double valorCompra;
	private Double prazo;
	private char aprovado;
	private Date dataPedido;
	private Date dataEntrega;
	private Integer idTipoFrete;
	private Integer idMeioPagamento;
	private Integer idJuros;
	private Integer IdEnderecoEntrega;
	private Integer IdUsuario;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}
	public Integer getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Double getPrazo() {
		return prazo;
	}
	public void setPrazo(Double prazo) {
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
	public Integer getIdTipoFrete() {
		return idTipoFrete;
	}
	public void setIdTipoFrete(Integer idTipoFrete) {
		this.idTipoFrete = idTipoFrete;
	}
	public Integer getIdMeioPagamento() {
		return idMeioPagamento;
	}
	public void setIdMeioPagamento(Integer idMeioPagamento) {
		this.idMeioPagamento = idMeioPagamento;
	}
	public Integer getIdJuros() {
		return idJuros;
	}
	public void setIdJuros(Integer idJuros) {
		this.idJuros = idJuros;
	}
	public Integer getIdEnderecoEntrega() {
		return IdEnderecoEntrega;
	}
	public void setIdEnderecoEntrega(Integer idEnderecoEntrega) {
		IdEnderecoEntrega = idEnderecoEntrega;
	}
	public Integer getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		IdUsuario = idUsuario;
	}

}
