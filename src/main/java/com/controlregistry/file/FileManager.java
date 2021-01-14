package com.controlregistry.file;

import java.util.List;

import org.springframework.stereotype.Service;

import com.controlregistry.entities.Registry;
import com.controlregistry.file.impl.MyFile;

/**
 * Classe abstração gerenciadora de arquivos
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
@Service
public interface FileManager {

	/**
	 * Método para leitura de arquivo
	 * 
	 * @param file - arquivo
	 * @return ist<Registry> - lista de matriculas
	 */
	List<Registry> readFile(MyFile file);

	/**
	 * Método para escrita de arquivo
	 * 
	 * @param file      - arquivo
	 * @param registers - lista de matriculas
	 * @return List<Registry> - lista de matriculas
	 */
	void writeFile(MyFile file, List<Registry> registers);
}
