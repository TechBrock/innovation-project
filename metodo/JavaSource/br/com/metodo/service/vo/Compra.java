package br.com.metodo.service.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Compra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date dataPedido;
	private String ordemCompra;
	private List<String> itensComprados;
	//TODO Verificar como quer fazer...
	private int quantidade;
	private double valorCompra;
	private double valorFrete;
	//TODO Verificar tipo
	private String tipoFrete;
	private int quantidadeParcelas;
	private int prazoEntrega;
	private Date dataEntrega;
	
	
}
