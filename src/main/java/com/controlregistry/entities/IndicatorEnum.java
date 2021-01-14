package com.controlregistry.entities;

/**
 * ENUM com indicador de verdadeiro ou falso da matricula
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */

public enum IndicatorEnum {
	V("verdadeiro"), F("falso");

	private String descricao;

	IndicatorEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
