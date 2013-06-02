package br.com.innovation.bo;

import java.util.ArrayList;


import br.com.innovation.dao.PedidoDao;
import br.com.innovation.vo.ModeloVo;
import br.com.innovation.vo.PedidoVo;

public class PedidoBo {
	private Integer idUser;
	private Integer idCompra;
	private ArrayList<PedidoVo> pedidoAl = new ArrayList<PedidoVo>();
	private ArrayList<ModeloVo> modeloAl = new ArrayList<ModeloVo>();

	
	public Integer getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Integer idCompra) {
		this.idCompra = idCompra;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public ArrayList<PedidoVo> getPedidoAl() {
		return pedidoAl;
	}

	public void setPedidoAl(ArrayList<PedidoVo> pedidoAl) {
		this.pedidoAl = pedidoAl;
	}
	public ArrayList<ModeloVo> getModeloAl() {
		return modeloAl;
	}

	public void setModeloAl(ArrayList<ModeloVo> modeloAl) {
		this.modeloAl = modeloAl;
	}

	public String getPedidoByUser(){
		if(idUser != null && idUser > 0){
			pedidoAl = new PedidoDao().getPedido(idUser);
			return "inn011";
		}else{
			return null;
		}
		
	}
	
	public String getItemPedido(){
			modeloAl = new PedidoDao().getItemCompra(idCompra);
		return "inn011detalhe";
	}


}
