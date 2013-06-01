package br.com.innovation.bo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import br.com.innovation.dao.EnderecoDao;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.service.boleto.BoletoService;
import br.com.innovation.vo.CarrinhoVo;
import br.com.innovation.vo.EnderecoVo;
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
	public boolean eCartao= false;
	private byte[] arrayBoleto;
	Integer idUsuario;
	Double valorCarrinho = 0.0;
	
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
	
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Double getValorCarrinho() {
		return valorCarrinho;
	}
	public void setValorCarrinho(Double valorCarrinho) {
		this.valorCarrinho = valorCarrinho;
	}
	public boolean iseCartao() {
		return eCartao;
	}
	public void seteCartao(boolean eCartao) {
		this.eCartao = eCartao;
	}
	
	public String comprar(){

		if(idUsuario == null || idUsuario <= 0){
			return "inn002";
		}else{
			usuVo = new UsuarioDao().getUsuarioById(usuVo.getId());
			telAl = new TelefoneDao().getTelefoneByUser(usuVo.getId());
			return "inn004compra";
		}
	}
	
	public void gerarBoleto(OutputStream stream, Object id){
		UsuarioVo usuVo = new UsuarioVo();
		EnderecoVo endVo = new EnderecoVo();
		usuVo = new UsuarioDao().getUsuarioById(idUsuario);
		endVo = new EnderecoDao().getEndByUser(idUsuario);
		arrayBoleto = BoletoService.gerarBoleto(usuVo, endVo, valorCarrinho, 1);
		try {
			stream.write(arrayBoleto);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public byte[] getArrayBoleto() {
		return arrayBoleto;
	}
	public void setArrayBoleto(byte[] arrayBoleto) {
		this.arrayBoleto = arrayBoleto;
	}
	

}
