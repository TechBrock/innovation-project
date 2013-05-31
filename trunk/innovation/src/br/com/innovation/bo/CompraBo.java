package br.com.innovation.bo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import br.com.innovation.dao.EnderecoDao;
import br.com.innovation.dao.TelefoneDao;
import br.com.innovation.dao.UsuarioDao;
import br.com.innovation.service.boleto.BoletoService;
import br.com.innovation.service.cartao.CCService;
import br.com.innovation.vo.CarrinhoVo;
import br.com.innovation.vo.CartaoVo;
import br.com.innovation.vo.CompraVo;
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
	CompraVo compraIns = new CompraVo();
	CartaoVo cartaoVo = new CartaoVo();
	String erroSubmit;
	private Integer qtdParcelas;
	private Double valorFrete;
	private Double valorProd;
	private Double valorParcelado;

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
	public CartaoVo getCartaoVo() {
		return cartaoVo;
	}
	public void setCartaoVo(CartaoVo cartaoVo) {
		this.cartaoVo = cartaoVo;
	}

	public String getErroSubmit() {
		return erroSubmit;
	}
	public void setErroSubmit(String erroSubmit) {
		this.erroSubmit = erroSubmit;
	}
	public Integer getQtdParcelas() {
		return qtdParcelas;
	}
	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}
	public Double getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(Double valorFrete) {
		this.valorFrete = valorFrete;
	}
	public Double getValorProd() {
		return valorProd;
	}
	public void setValorProd(Double valorProd) {
		this.valorProd = valorProd;
	}
	public Double getValorParcelado() {
		return valorParcelado;
	}
	public void setValorParcelado(Double valorParcelado) {
		this.valorParcelado = valorParcelado;
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
		finalizarCompra(1, endVo.getId(), usuVo.getId());
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

	public void finalizarCompra(Integer tipoPag, Integer idEnd, Integer idUser){
		
		compraIns.setAprovado('N');
		compraIns.setDesconto(0.0);
		compraIns.setIdEnderecoEntrega(idEnd);
		compraIns.setIdMeioPagamento(tipoPag);
		compraIns.setIdJuros(1);
		compraIns.setIdTipoFrete(1);
		compraIns.setIdUsuario(idUsuario);
//		compraIns.setOrdemCompra((int) (new Date().getTime()/1000));
//		compraIns.setPrazo(10);
		compraIns.setQtdParcelas(qtdParcelas);
		compraIns.setValorFrete(valorFrete);
		compraIns.setValorCompra(valorProd);
//		new CompraDao().inserir(compraIns);
	}


	public String validarCartao(){
		UsuarioVo usuVo = new UsuarioVo();
		EnderecoVo endVo = new EnderecoVo();
		usuVo = new UsuarioDao().getUsuarioById(idUsuario);
		endVo = new EnderecoDao().getEndByUser(idUsuario);
		
		int bandeira = cartaoVo.getBandeira();
		String numeroCartao = cartaoVo.getNumero();
		if(CCService.validarNumero(numeroCartao)){
			if(CCService.validarBandeira(numeroCartao, bandeira)){
				if(CCService.validarNumeroCartao(numeroCartao, bandeira)){
					finalizarCompra(2, endVo.getId(), usuVo.getId());
					setErroSubmit("Cartão Validado!");
				}else{
					setErroSubmit("Cartão inválido!");
				}
			}else{
				setErroSubmit("Numero incorreto!");
			}
		}
		return null;
	}
	
	public String calcParcelas(){
		valorParcelado = (valorCarrinho / qtdParcelas);
		return null;
	}

}
