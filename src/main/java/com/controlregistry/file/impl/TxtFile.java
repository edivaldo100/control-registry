package com.controlregistry.file.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.controlregistry.entities.Registry;

/**
 * Classe especifica de arquivos txt
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
public class TxtFile extends MyFile {

	private String path;
	private List<Registry> listRegistry;

	public TxtFile(String path) {
		this.path = path;
	}

	@Override
	public FileReader getFile() throws FileNotFoundException {
		return new FileReader(this.path);
	}

	@Override
	public boolean fileExist() {
		if (new File(this.path).exists())
			return true;
		return false;
	}

	public String getPath() {
		return path;
	}

	@Override
	public FileWriter writeFile() throws IOException {
		return new FileWriter(this.path);
	}

	public List<Registry> getListRegistry() {
		return listRegistry;
	}

	public void setListRegistry(List<Registry> listRegistry) {
		this.listRegistry = listRegistry;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
