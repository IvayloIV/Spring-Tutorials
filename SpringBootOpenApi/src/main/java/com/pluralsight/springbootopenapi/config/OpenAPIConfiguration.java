package com.pluralsight.springbootopenapi.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
    info = @Info(
    title = "Applications API",
    description = "Applications Information",
    contact = @Contact(
        name = "Ivaylo",
        url = "https://google.com",
        email = "ivaylo@abv.bg"
    ),
    license = @License(
        name = "MIT Licence",
        url = "https://github.com/thombergs/code-examples/blob/master/LICENSE"))
)
@SecurityScheme(
    name = "applicationapi",
    scheme = "basic",
    type = SecuritySchemeType.HTTP,
    in = SecuritySchemeIn.HEADER
)
@Configuration
public class OpenAPIConfiguration {
}
