package br.com.innovation.enums;

public enum TipoTelefoneEnum {
	CELULAR(1),
	RESIDENCIAL(2),
	COMERCIAL(3);
	
	int tel;
	
	private TipoTelefoneEnum(int tel){
		this.tel = tel;
	}

}
