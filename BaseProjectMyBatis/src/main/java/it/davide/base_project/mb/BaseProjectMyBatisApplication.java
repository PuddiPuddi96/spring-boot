package it.davide.base_project.mb;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Ciao",
				version = "1.0.0",
				description = "Ave",
				termsOfService = "aaa",
				contact = @Contact(
						name = "Puddi",
						email = "aaa@aaa.com"
				),
				license = @License(
						name = "aaa",
						url = "ssss"
				)
		)
)
public class BaseProjectMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseProjectMyBatisApplication.class, args);
	}

}
