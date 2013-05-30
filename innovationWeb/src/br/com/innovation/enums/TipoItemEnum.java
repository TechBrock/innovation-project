package br.com.innovation.enums;

public enum TipoItemEnum {
	
	BICICLETA(1),
	PATINETE(2);
	
	Integer id;
	
	TipoItemEnum(Integer id){
		this.id = id;
	}

}
