package br.com.innovation.service.cartao;

public enum BandeiraCC{
	VISA(0),
	MASTERCARD(1),
	AMERICAN_EXPRESS(2);
	
	private int codigoBandeira;

	public int getCodigoBandeira() {
		return codigoBandeira;
	}
	
	public void setCodigoBandeira(int codigoBandeira) {
		this.codigoBandeira = codigoBandeira;
	}

	private BandeiraCC(int codigoBandeira){
		this.codigoBandeira = codigoBandeira;
	}
	
}