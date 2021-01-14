package com.controlregistry.file.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe abstração de arquivos
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public abstract class MyFile {
	public abstract FileReader getFile() throws FileNotFoundException;

	public abstract FileWriter writeFile() throws IOException;

	public abstract boolean fileExist();
}
