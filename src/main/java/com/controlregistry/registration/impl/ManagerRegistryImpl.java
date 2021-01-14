package com.controlregistry.registration.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controlregistry.entities.IndicatorEnum;
import com.controlregistry.entities.Registry;
import com.controlregistry.exceptions.ValidRegistrationException;
import com.controlregistry.registration.ManagerRegistry;
import com.controlregistry.registration.validator.Validator;

/**
 * Classe gerenciadora de arquivos
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public class ManagerRegistryImpl implements ManagerRegistry {
	private static final Logger log = LoggerFactory.getLogger(ManagerRegistryImpl.class);

	@Override
	public Registry checkDigitWithDV(Registry registry, Validator validator) throws ValidRegistrationException {
		String[] splitnumbers = registry.getValue().split("-");
		String valueNew = splitnumbers[0];
		Registry registryTemp = new Registry(valueNew);
		Registry checkDigitCalculationNew = checkDigitCalculation(registryTemp, validator);

		return comperRegisty(registry, checkDigitCalculationNew);
	}

	private Registry comperRegisty(Registry r1, Registry r2) {
		Registry tempRegistry = r2;
		if (r1.getValue().equals(r2.getValue())) {
			tempRegistry.setValue(r2.getValue() + " " + IndicatorEnum.F.getDescricao());
		} else {
			tempRegistry.setValue(r2.getValue() + " " + IndicatorEnum.V.getDescricao());
		}
		return tempRegistry;
	}

	@Override
	public Registry checkDigitCalculation(Registry registry, Validator validator) throws ValidRegistrationException {
		int numberFinal = 0;
		int rule = 5;
		if (!validator.validNumber(registry.getValue()))
			throw new ValidRegistrationException("ERRO AO VALIDAR A ATRICULA.");
		String[] splitnumbers = registry.getValue().split("");

		for (String digit : splitnumbers) {
			Integer validDigit = validDigit(digit);
			numberFinal += validDigit * rule;

			rule--;
		}
		numberFinal = numberFinal % 16;

		String digit = Integer.toString(numberFinal, 16).toUpperCase();

		return new Registry(registry.getValue() + "-" + digit, validator);
	}

	private Integer validDigit(String numero) {

		try {
			return Integer.parseInt(numero);
		} catch (NumberFormatException e) {
			log.error("ERRO AO LER UMA DAS LINHAS DO ARQUIVO!");
			e.printStackTrace();
			throw new NumberFormatException("ERRO AO LER UMA DAS LINHAS DO ARQUIVO!");
		}
	}

}
