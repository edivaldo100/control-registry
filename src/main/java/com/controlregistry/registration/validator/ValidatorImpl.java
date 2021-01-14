package com.controlregistry.registration.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe validador
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public class ValidatorImpl implements Validator {
	private static final String PATTERN = "[0-9]{4}";

	@Override
	public boolean validNumber(String numero) {
		Pattern p = Pattern.compile(PATTERN);
		Matcher m1 = p.matcher(numero);
		if (!m1.matches()) {
			return false;
		}
		return true;
	}

}
