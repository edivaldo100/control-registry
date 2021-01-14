package com.controlregistry.registration.validator;

import org.springframework.stereotype.Service;

import com.controlregistry.exceptions.ValidRegistrationException;

@Service
public interface Validator {

	/**
	 * Método para validar a matricula
	 * 
	 * @param numero - matricula
	 * @return boolean
	 * @throws ValidRegistrationException
	 */
	boolean validNumber(String numero);
}
