package it.davide.spring.bsp.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Base Spring Project",
                description = "This is a Swagger for the project",
                contact = @Contact(
                        name = "Davide Benedetto Strianese",
                        email = "d.b.strianese96@hotmail.com"
                ),
                version = "1.0.0",
                summary = "To do a Summary"
        )
)
public class SwaggerConfig {

}
