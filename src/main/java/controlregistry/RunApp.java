package controlregistry;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.controlregistry.entities.Registry;
import com.controlregistry.exceptions.ValidRegistrationException;
import com.controlregistry.file.FileManager;
import com.controlregistry.file.impl.MyFile;
import com.controlregistry.file.impl.TxtFile;
import com.controlregistry.registration.ManagerRegistry;
import com.controlregistry.registration.validator.Validator;

import controlregistry.constants.Constants;

/**
 * Classe de execução
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public class RunApp {

	private static final Logger log = LoggerFactory.getLogger(RunApp.class);

	@Autowired
	private FileManager fileManager;
	@Autowired
	private ManagerRegistry managerRegistry;
	@Autowired
	private Validator validator;

	/**
	 * Método para executar a 1 fase da app
	 * 
	 * @return void
	 * @throws FileNotFoundException
	 */
	public void appStart1() throws FileNotFoundException {

		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_SEM_DV);
		List<Registry> readFile = fileManager.readFile(txtFile);
		List<Registry> list = new ArrayList<>();
		readFile.forEach(registry -> {
			try {
				Registry checkDigitCalculation = managerRegistry.checkDigitCalculation(registry, validator);
				list.add(checkDigitCalculation);

				MyFile txtFileWrite = new TxtFile(Constants.PATH_MATRICULAS_COM_DV);
				fileManager.writeFile(txtFileWrite, list);

			} catch (ValidRegistrationException e) {
				e.printStackTrace();
			}

		});
		log.info("SEM DV = " + readFile);
		log.info("COM DV = " + list.toString());
	}

	/**
	 * Método para executar a 2 fase da app
	 * 
	 * @return void
	 * @throws FileNotFoundException
	 */
	public void appStart2() throws FileNotFoundException {
		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_P_VERIFICAR);
		List<Registry> readFile = fileManager.readFile(txtFile);
		List<Registry> list = new ArrayList<>();
		readFile.forEach(registry -> {
			try {
				Registry checkDigitCalculation = managerRegistry.checkDigitWithDV(registry, validator);
				list.add(checkDigitCalculation);

				MyFile txtFileWrite = new TxtFile(Constants.PATH_MATRICULAS_COM_DV);
				fileManager.writeFile(txtFileWrite, list);
				MyFile txtFileWriteCheck = new TxtFile(Constants.PATH_MATRICULAS_VERIFICADAS);
				fileManager.writeFile(txtFileWriteCheck, list);
			} catch (ValidRegistrationException e) {
				e.printStackTrace();
			}

		});
		log.info("matriculasParaVerificar SEM DV = " + readFile);
		log.info("matriculasParaVerificar COM DV = " + list.toString());
	}
}
