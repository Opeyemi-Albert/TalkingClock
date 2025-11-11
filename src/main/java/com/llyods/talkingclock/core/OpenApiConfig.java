package com.llyods.talkingclock.core;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author Opeyemi Adeoye
 * @since 2023-11-10
 */
@OpenAPIDefinition(
    info =
        @Info(
            contact = @Contact(name = "Workings"),
            description = "OpenApi Documentation for Talking Clock",
            title = "Talking Clock",
            version = "1.0.0"),
    servers = {@Server(description = "Local ENV", url = "http://localhost:8080")})
public class OpenApiConfig {}
