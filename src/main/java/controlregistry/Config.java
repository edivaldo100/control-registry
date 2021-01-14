package controlregistry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.controlregistry.file.impl.FileManagerImpl;
import com.controlregistry.registration.impl.ManagerRegistryImpl;

/**
 * Classe de configuração da app
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */

@Configuration
public class Config {
	@Bean
	public ManagerRegistryImpl managerRegistry() {
		return new ManagerRegistryImpl();
	}

	@Bean
	public FileManagerImpl fileManager() {
		return new FileManagerImpl();
	}

	@Bean
	public RunApp app() {
		return new RunApp();
	}

}
