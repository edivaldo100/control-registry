package com.controlregistry.registration;

import com.controlregistry.entities.Registry;
import com.controlregistry.exceptions.ValidRegistrationException;
import com.controlregistry.registration.validator.Validator;

/**
 * Interface gerenciadora de matricula
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public interface ManagerRegistry {

	/**
	 * Método para validar o calculo da matricula
	 * 
	 * @param registry  - matricula
	 * @param validator - validador
	 * @return Registry - matriculas
	 * @throws ValidRegistrationException
	 */
	Registry checkDigitCalculation(Registry registry, Validator validator) throws ValidRegistrationException;

	/**
	 * Método para validar a matricula
	 * 
	 * @param registry  - matricula
	 * @param validator - validador
	 * @return Registry - matriculas
	 * @throws ValidRegistrationException
	 */
	Registry checkDigitWithDV(Registry registry, Validator validator) throws ValidRegistrationException;
}
