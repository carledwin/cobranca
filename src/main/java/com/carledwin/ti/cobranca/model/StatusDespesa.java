package com.carledwin.ti.cobranca.model;

public enum StatusDespesa {
	A_VENCER("À vencer"), VENCIDA("Vencida"), PAGA("Paga"), PAGA_ATRASO("Paga com atraso");
	
	private String descricao;
	
	StatusDespesa(String descricao){
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
