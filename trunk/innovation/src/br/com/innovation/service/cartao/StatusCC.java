package br.com.innovation.service.cartao;

public enum StatusCC{
	BANDEIRA_INVALIDA("99"),
	NUMERO_CARTAO_INVALIDO("98"),
	CARTAO_VALIDADO("01"),
	VENDA_OK("02"),
	VENDA_NAO_AUTORIZADA("97");

	private String codigoStatus;

	public String getCodigoStatus() {
		return codigoStatus;
	}

	public void setCodigoStatus(String codigoStatus) {
		this.codigoStatus = codigoStatus;
	}

	private StatusCC(String codigoStatus){
		this.codigoStatus = codigoStatus;
	}
}