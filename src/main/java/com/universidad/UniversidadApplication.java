package com.universidad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.cache.annotation.EnableCaching;



@SpringBootApplication
@OpenAPIDefinition(
    info = @Info(
        title = "Sistema de Registro Universitario",
        version = "1.0",
        description = "Documentación de la API del sistema universitario"
    )
)

@EnableCaching
public class UniversidadApplication {
    public static void main(String[] args) {
        SpringApplication.run(UniversidadApplication.class, args);
    }
}

