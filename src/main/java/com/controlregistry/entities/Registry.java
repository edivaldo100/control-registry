package com.controlregistry.entities;

import com.controlregistry.registration.validator.Validator;

/**
 * Classe matricula
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public class Registry {

	private IndicatorEnum indicator;
	private String value;

	public Registry(String value) {
		this.value = value;
	}

	public Registry(String value, IndicatorEnum indicator) {
		this.value = value;
		this.indicator = indicator;
	}

	public Registry(String value, Validator validator) {
		this.value = value;
		if (validator.validNumber(value))
			this.indicator = IndicatorEnum.V;
		else
			this.indicator = IndicatorEnum.F;
	}

	public String valueAndIndicator() {
		return this.value + " " + this.indicator.getDescricao();
	}

	public IndicatorEnum getIndicator() {
		return indicator;
	}

	public void setIndicator(IndicatorEnum indicator) {
		this.indicator = indicator;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Registry [value=" + value + "]";
	}

}
