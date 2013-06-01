package br.com.innovation.enums;

public enum PerfilEnum {
	
	CLIENTE(1),
	ADMIN(2),
	GERENTE(3);
	
	int id;
	
	private PerfilEnum(int id){
		this.id = id;
	}

}
