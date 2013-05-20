package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.vo.CarrinhoVo;
import br.com.innovation.vo.TelefoneVo;
import br.com.innovation.vo.UsuarioVo;

public class CompraBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4349708120638447587L;
	UsuarioVo usuVo = new UsuarioVo();
	CarrinhoVo carrinhoVo = new CarrinhoVo();
	ArrayList<TelefoneVo> telAl = new ArrayList<TelefoneVo>();
	
	public UsuarioVo getUsuVo() {
		return usuVo;
	}
	public void setUsuVo(UsuarioVo usuVo) {
		this.usuVo = usuVo;
	}

	public CarrinhoVo getCarrinhoVo() {
		return carrinhoVo;
	}


	public void setCarrinhoVo(CarrinhoVo carrinhoVo) {
		this.carrinhoVo = carrinhoVo;
	}
	
	public ArrayList<TelefoneVo> getTelAl() {
		return telAl;
	}
	public void setTelAl(ArrayList<TelefoneVo> telAl) {
		this.telAl = telAl;
	}
	
	public String comprar(){

		if(usuVo.getId() == null || usuVo.getId() <= 0){
			return "inn002";
		}else{
			usuVo = new UsuarioDao().getUsuarioById(usuVo.getId());
			telAl = new TelefoneDao().getTelefoneByUser(usuVo.getId());
			return "inn004compra";
		}
	}

}
