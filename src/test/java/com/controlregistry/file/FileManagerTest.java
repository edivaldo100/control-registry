package com.controlregistry.file;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.controlregistry.entities.Registry;
import com.controlregistry.exceptions.ValidRegistrationException;
import com.controlregistry.file.impl.MyFile;
import com.controlregistry.file.impl.TxtFile;
import com.controlregistry.registration.ManagerRegistry;
import com.controlregistry.registration.validator.Validator;

import controlregistry.Application;
import controlregistry.constants.Constants;

/**
 * Classe de testes usada na app
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class FileManagerTest {
	private static final Logger log = LoggerFactory.getLogger(FileManagerTest.class);
	@Autowired
	private FileManager fileManager;
	@Autowired
	private ManagerRegistry managerRegistry;

	@Autowired
	private Validator validator;

	@Test
	public void testFileExist() throws FileNotFoundException {
		TxtFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_SEM_DV);
		
		assertNotNull(txtFile.fileExist());
	}

	@Test
	public void testReadFile() throws FileNotFoundException {
		TxtFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_SEM_DV);
		List<Registry> readFile = fileManager.readFile(txtFile);
		assertTrue(!readFile.isEmpty());
	}

	@Test
	public void testCheckDigitCalculation() throws FileNotFoundException {
		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_SEM_DV);
		List<Registry> readFile = fileManager.readFile(txtFile);
		List<Registry> list = new ArrayList<>();
		readFile.forEach(registry -> {
			try {
				Registry checkDigitCalculation = managerRegistry.checkDigitCalculation(registry, validator);
				list.add(checkDigitCalculation);
			} catch (ValidRegistrationException e) {
				e.printStackTrace();
			}

		});

		assertTrue(!list.isEmpty());
	}

	@Test
	public void testFileWriteExist() throws FileNotFoundException {
		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_COM_DV);
		assertNotNull(txtFile.fileExist());
	}

	@Test
	public void testWriteFile() throws FileNotFoundException {

		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_SEM_DV);
		List<Registry> readFile = fileManager.readFile(txtFile);
		List<Registry> list = new ArrayList<>();
		readFile.forEach(registry -> {
			try {
				Registry checkDigitCalculation = managerRegistry.checkDigitCalculation(registry, validator);
				list.add(checkDigitCalculation);
			} catch (ValidRegistrationException e) {
				e.printStackTrace();
			}

		});
		log.info("SEM DV = " + readFile);
		MyFile txtFileWrite = new TxtFile(Constants.PATH_MATRICULAS_COM_DV);
		fileManager.writeFile(txtFileWrite, list);
		log.info("COM DV = " + list.toString());
		assertNotNull(txtFileWrite.fileExist());

	}

	@Test
	public void testFileToVerify() throws FileNotFoundException {
		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_P_VERIFICAR);
		assertNotNull(txtFile.fileExist());
	}

	@Test
	public void testFileToVerifyCheck_V_F() throws FileNotFoundException {
		MyFile txtFile = new TxtFile(Constants.PATH_MATRICULAS_P_VERIFICAR);
		List<Registry> readFile = fileManager.readFile(txtFile);
		List<Registry> list = new ArrayList<>();
		readFile.forEach(registry -> {
			try {
				Registry checkDigitCalculation = managerRegistry.checkDigitWithDV(registry, validator);
				list.add(checkDigitCalculation);
			} catch (ValidRegistrationException e) {
				e.printStackTrace();
			}

		});
		log.info("SEM DV = " + readFile);
		MyFile txtFileWrite = new TxtFile(Constants.PATH_MATRICULAS_COM_DV);
		fileManager.writeFile(txtFileWrite, list);
		log.info("COM DV = " + list.toString());

		MyFile txtFileWriteCheck = new TxtFile(Constants.PATH_MATRICULAS_VERIFICADAS);
		fileManager.writeFile(txtFileWriteCheck, list);

		assertNotNull(txtFileWrite.fileExist());
	}

}
