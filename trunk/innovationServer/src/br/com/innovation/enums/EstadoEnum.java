package br.com.innovation.enums;

public enum EstadoEnum {
	AC("Acre",1),	
	AL("Alagoas",2),
	AP("Amap�",4),
	AM("Amazonas",3),	
	BA("Bahia",5),
	CE("Cear�",6),
	DF("Distrito Federal",7),	
	ES("Esp�rito Santo",8),	
	GO("Goi�s",9),	
	MA("Maranh�o",10),	
	MT("Mato Grosso",13),	
	MS("Mato Grosso do Sul",12),		
	MG("Minas Gerais",11),		
	PA("Par�",14),		
	PB("Para�ba",15),		
	PR("Paran�",18),		
	PE("Pernambuco",16),	
	PI("Piau�",17),		
	RJ("Rio de Janeiro",19),	
	RN("Rio Grande do Norte",20),		
	RS("Rio Grande do Sul",23),		
	RO("Rond�nia",21),		
	RR("Roraima",22),		
	SC("Santa Catarina",24),	
	SP("S�o Paulo",26),		
	SE("Sergipe",25),		
	TO("Tocantins",27),
	INV("",0);

	private String estado;
	private Integer id;

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private EstadoEnum(String estado, Integer id){
		this.estado = estado;
		this.id = id;
	}

	public static String getNomeEstado(String estado) {
		EstadoEnum[] estadoE= EstadoEnum.values();

		for(int x = 0; x < estadoE.length; x++){
			if(estadoE[x].name().equals(estado)){
				return estadoE[x].estado;
			}

		}
		return estadoE[27].estado;
	}
	
	public static String getUfEstado(String est) {
		EstadoEnum[] estadoE= EstadoEnum.values();

		for(int x = 0; x < estadoE.length; x++){
			if(estadoE[x].getEstado().equals(est)){
				return estadoE[x].name();
			}

		}
		return estadoE[27].name();
	}
	
	public static Integer getIdEstado(String uf) {
		EstadoEnum[] estadoE= EstadoEnum.values();
		for(int x = 0; x < estadoE.length; x++){
			if(estadoE[x].name().equals(uf)){
				return estadoE[x].id;
			}

		}
		return estadoE[27].id;
	}


}
