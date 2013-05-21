package br.com.innovation.bo;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import org.richfaces.component.html.HtmlDataGrid;

import br.com.innovation.dao.ModeloDao;
import br.com.innovation.vo.CarrinhoVo;
import br.com.innovation.vo.ModeloVo;

public class CarrinhoBo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1771701788440661022L;

	CarrinhoVo carrinhoVo = new CarrinhoVo();
	CarrinhoVo carrinhoRemove = new CarrinhoVo();
	ModeloVo modeloVo = new ModeloVo();
	ArrayList<CarrinhoVo> carrinhoAl = new ArrayList<CarrinhoVo>();
	private Integer qtdCart = 0;
	private Double totalCart = 0.0;
	private Integer idUser;

	public CarrinhoVo getCarrinhoVo() {
		return carrinhoVo;
	}

	public void setCarrinhoVo(CarrinhoVo carrinhoVo) {
		this.carrinhoVo = carrinhoVo;
	}

	public CarrinhoVo getCarrinhoRemove() {
		return carrinhoRemove;
	}

	public void setCarrinhoRemove(CarrinhoVo carrinhoRemove) {
		this.carrinhoRemove = carrinhoRemove;
	}

	public ArrayList<CarrinhoVo> getCarrinhoAl() {
		return carrinhoAl;
	}

	public void setCarrinhoAl(ArrayList<CarrinhoVo> carrinhoAl) {
		this.carrinhoAl = carrinhoAl;
	}

	public ModeloVo getModeloVo() {
		return modeloVo;
	}

	public void setModeloVo(ModeloVo modeloVo) {
		this.modeloVo = modeloVo;
	}

	public Integer getQtdCart() {
		return qtdCart;
	}

	public void setQtdCart(Integer qtdCart) {
		this.qtdCart = qtdCart;
	}
	public Double getTotalCart() {
		return totalCart;
	}

	public void setTotalCart(Double totalCart) {
		this.totalCart = totalCart;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String addToCart(){
		totalCart = 0.0;
		boolean add = true;
		carrinhoVo.setIdModelo(modeloVo.getId());
		carrinhoVo.setPrecoModelo(modeloVo.getPrecoAtual());
		carrinhoVo.setNomeModelo(modeloVo.getNome());
		carrinhoVo.setQtdModelo(1);
		carrinhoVo.setValorTotal(carrinhoVo.getPrecoModelo());


		for (CarrinhoVo cart : carrinhoAl) {
			if(cart.getIdModelo().intValue() == carrinhoVo.getIdModelo().intValue()){
				add = false;
				break;
			}
		}

		if(add){
			carrinhoAl.add(carrinhoVo);
		}

		for (CarrinhoVo cart : carrinhoAl) {
			totalCart += cart.getValorTotal();
		}
		carrinhoVo = new CarrinhoVo();
		return null;

	}

	public String removeToCart(){
		totalCart = 0.0;
		carrinhoAl.remove(carrinhoRemove);

		for (CarrinhoVo cart : carrinhoAl) {
			totalCart += cart.getValorTotal();
		}

		return "inn004carrinhoReturn";
	}

	public void montaImagem(OutputStream strem, Object id){
		String principal = null;
		String principalNew = null;
		FileInputStream origem = null;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] array;
		int x;

		if((Integer) id != null && (Integer) id > 0){
			principal = new ModeloDao().getCaminho("img_1",(Integer) id);
			principalNew = principal.substring(principal.lastIndexOf("/")+1,principal.length());

			try {
				origem = new FileInputStream("C:\\newWork\\imagens_produto\\"+principalNew);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}

			try {
				while((x = origem.read()) > -1){
					out.write(x);
				}

				out.close();
				origem.close();
				array = out.toByteArray();
				strem.write(array);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getCalcValorTotal(){
		totalCart = 0.0;
		for (CarrinhoVo cart : carrinhoAl) {
			if(cart.getIdModelo().intValue() == carrinhoVo.getIdModelo().intValue()){
				cart.setValorTotal(carrinhoVo.getPrecoModelo()*carrinhoVo.getQtdModelo());
			}
		}

		for (CarrinhoVo cart : carrinhoAl) {
			totalCart += cart.getValorTotal();
		}
		carrinhoVo = new CarrinhoVo();

		return "inn004carrinho";
	}


	public HtmlDataGrid getInitTable(){
		getCalcValorTotal();
		return null;
	}

	public void setInitTable(HtmlDataGrid table){}
	
	public void zeraCarrinho(){
		carrinhoVo = new CarrinhoVo();
		carrinhoRemove = new CarrinhoVo();
		carrinhoAl.clear();
		idUser = 0;
		totalCart = 0.0;
		qtdCart = 0;
	}

}
