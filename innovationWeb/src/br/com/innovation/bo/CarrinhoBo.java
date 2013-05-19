package br.com.innovation.bo;

import java.io.Serializable;
import java.util.ArrayList;

import br.com.innovation.vo.CarrinhoVo;

public class CarrinhoBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1771701788440661022L;
	
	CarrinhoVo carrinhoVo = new CarrinhoVo();
	ArrayList<CarrinhoVo> carrinhoAl = new ArrayList<CarrinhoVo>();

	public CarrinhoVo getCarrinhoVo() {
		return carrinhoVo;
	}

	public void setCarrinhoVo(CarrinhoVo carrinhoVo) {
		this.carrinhoVo = carrinhoVo;
	}
	public ArrayList<CarrinhoVo> getCarrinhoAl() {
		return carrinhoAl;
	}

	public void setCarrinhoAl(ArrayList<CarrinhoVo> carrinhoAl) {
		this.carrinhoAl = carrinhoAl;
	}

	public String addToCart(){
		carrinhoAl.add(carrinhoVo);
		return null;
		
	}
}
