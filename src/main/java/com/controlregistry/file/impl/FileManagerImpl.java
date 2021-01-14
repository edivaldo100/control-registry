package com.controlregistry.file.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.controlregistry.entities.Registry;
import com.controlregistry.file.FileManager;

/**
 * Classe  de implementação gerenciadora de arquivos
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */

public class FileManagerImpl implements FileManager {

	private static final Logger log = LoggerFactory.getLogger(FileManagerImpl.class);

	public List<Registry> readFile(MyFile file) {
		List<Registry> registers = new ArrayList<>();
		try {
			BufferedReader buffRead = new BufferedReader(file.getFile());
			String linha = "";
			while (true) {
				if (linha != null) {
					if (linha != "")
						registers.add(new Registry(linha.trim()));
				} else
					break;
				linha = buffRead.readLine();
			}
			buffRead.close();
		} catch (NumberFormatException e) {
			log.error("ERRO AO LER UMA DAS LINHAS DO ARQUIVO!");
			e.printStackTrace();
		} catch (Exception e) {
			log.error("ERRO AO LER ARQUIVO!");
			e.printStackTrace();
		}
		return registers;
	}

	@Override
	public void writeFile(MyFile file, List<Registry> listRegisters) {
		try {
			BufferedWriter buffWrite = new BufferedWriter(file.writeFile());
			for (Registry register : listRegisters) {
				buffWrite.append(register.getValue() + "\n");
			}

			buffWrite.close();
		} catch (Exception e) {
			log.error("ERRO AO LER ARQUIVO!");
			e.printStackTrace();
		}
	}
}
