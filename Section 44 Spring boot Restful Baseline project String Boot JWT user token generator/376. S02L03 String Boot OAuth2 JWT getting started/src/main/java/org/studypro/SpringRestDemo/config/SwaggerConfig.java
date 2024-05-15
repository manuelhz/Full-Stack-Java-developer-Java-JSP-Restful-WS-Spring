package org.studypro.SpringRestDemo.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@Configuration
@OpenAPIDefinition(
    info =@Info(
        title = "Demo API",
        version = "version 1.0",
        contact = @Contact(
            name = "StudyPro", email = "admin@studypro.org", url = "http://studypro.org"
        ),
        license = @License(
            name = "Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0"
        ),
        termsOfService = "https://studypro.org/TOS",
        description = "Spring Boot Restful API demo by Manuel"
    )
)
public class SwaggerConfig {
    
}
