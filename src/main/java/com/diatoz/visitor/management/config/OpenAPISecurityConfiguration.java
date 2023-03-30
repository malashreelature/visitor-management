package com.diatoz.visitor.management.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info =@Info(
                title = "VisitorManagement API",
                version = "${api.version}",
                contact = @Contact(
                        name = "diatoz", email = "Visitor-apis@daitozg.com", url = "https://www.diatoz.com"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                )),

        servers = @Server(
                url = "${api.server.url}",
                description = "Production"
        )
)
public class OpenAPISecurityConfiguration {}
