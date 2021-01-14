package controlregistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.controlregistry.registration.validator.Validator;
import com.controlregistry.registration.validator.ValidatorImpl;

/**
 * Classe Start app
 * 
 * @author Edivaldo
 * @version 1.0.0
 * @since Release 01 da aplicação
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private RunApp app;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---------------------------------------------------->>>>>>>>>>");
		System.out.println("-----------------------START APP--------------------->>>>>>>>>");
		System.out.println("---------------------------------------------------->>>>>>>>>>");

		app.appStart1();
		app.appStart2();
	}

	@Bean
	public ValidatorImpl validatorImpl() {
		return new ValidatorImpl();
	}

	@Bean
	public Validator validator() {
		return new ValidatorImpl();
	}
}
