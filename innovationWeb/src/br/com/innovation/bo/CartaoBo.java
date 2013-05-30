package br.com.innovation.bo;

import br.com.innovation.service.cartao.CCService;
import br.com.innovation.vo.CartaoVo;
public class CartaoBo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1766114382514865603L;
	private CartaoVo cartaoVo = new CartaoVo();
	private String erroSubmitCartao = "Seu cartão é válido??";
	private String erroSubmitBoleto = "Gerar boleto?";
	private boolean mostrarErro;
	private String enderecoImagem = null;
	private String nomeBoleto;
	private double valorboleto;
	private byte[] array;
	private boolean boletoGerado;

	public boolean isMostrarErro() {
		return mostrarErro;
	}
	public void setMostrarErro(boolean mostrarErro) {
		this.mostrarErro = mostrarErro;
	}
	public String getEnderecoImagem() {
		return enderecoImagem;
	}
	public void setEnderecoImagem(String enderecoImagem) {
		this.enderecoImagem = enderecoImagem;
	}

	public CartaoVo getCartaoVo() {
		return cartaoVo;
	}

	public void setCartaoVo(CartaoVo cartaoVo) {
		this.cartaoVo = cartaoVo;
	}

	public String getNomeBoleto() {
		return nomeBoleto;
	}

	public void setNomeBoleto(String nomeBoleto) {
		this.nomeBoleto = nomeBoleto;
	}

	public double getValorboleto() {
		return valorboleto;
	}

	public void setValorboleto(double valorboleto) {
		this.valorboleto = valorboleto;
	}

	public byte[] getArray() {
		return array;
	}

	public void setArray(byte[] array) {
		this.array = array;
	}
	public boolean isBoletoGerado() {
		return boletoGerado;
	}

	public void setBoletoGerado(boolean boletoGerado) {
		this.boletoGerado = boletoGerado;
	}

	public String getErroSubmitCartao() {
		return erroSubmitCartao;
	}

	public void setErroSubmitCartao(String erroSubmitCartao) {
		this.erroSubmitCartao = erroSubmitCartao;
	}

	public String getErroSubmitBoleto() {
		return erroSubmitBoleto;
	}

	public void setErroSubmitBoleto(String erroSubmitBoleto) {
		this.erroSubmitBoleto = erroSubmitBoleto;
	}

	public String validarCartao(){
		int bandeira = cartaoVo.getBandeira();
		String numeroCartao = cartaoVo.getNumero();
		if(CCService.validarNumero(numeroCartao)){
			if(CCService.validarBandeira(numeroCartao, bandeira)){
				if(CCService.validarNumeroCartao(numeroCartao, bandeira)){
					setErroSubmitCartao("Cartão Validado!");
				}else{
					setErroSubmitCartao("Cartão inválido!");
				}
			}else{
				setErroSubmitCartao("Numero incorreto!");
			}
		}
		return null;
	}
}
