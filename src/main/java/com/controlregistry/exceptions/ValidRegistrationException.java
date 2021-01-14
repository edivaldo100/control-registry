package com.controlregistry.exceptions;

/**
 * Classe Especifica de manipulação de exceptions
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public class ValidRegistrationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValidRegistrationException(String string) {
		super(string);
	}

}
