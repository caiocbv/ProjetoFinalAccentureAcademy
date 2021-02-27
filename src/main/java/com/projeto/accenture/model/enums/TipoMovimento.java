package com.projeto.accenture.model.enums;

public enum TipoMovimento {
	
	RECEITAS(1,"RECEITAS"),
	DESPESAS(2,"DESPESAS"),
	TRANSFERENCIA(3,"TRANSFERENCIA");
	
	private int cod;
	private String desc;
	
	private TipoMovimento(int cod, String desc) {
		this.cod = cod;
		this.desc = desc;
	}

	public int getCod() {
		return cod;
	}

	public String getDesc() {
		return desc;
	}

	
	public static TipoMovimento toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}
		
		for(TipoMovimento x : TipoMovimento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Acesso inválido");
	}
	

}
