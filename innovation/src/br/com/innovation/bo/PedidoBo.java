package br.com.innovation.bo;

import java.util.ArrayList;


import br.com.innovation.dao.PedidoDao;
import br.com.innovation.vo.PedidoVo;

public class PedidoBo {
	private Integer idUser;
	private ArrayList<PedidoVo> pedidoAl = new ArrayList<PedidoVo>();

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



	public String getPedidoByUser(){
		if(idUser != null && idUser > 0){
			pedidoAl = new PedidoDao().getPedido(idUser);
			return "inn011";
		}else{
			return null;
		}
		
	}


}
