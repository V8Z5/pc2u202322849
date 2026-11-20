package com.aquamonitor.platform.u202322849;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Starts the AquaMonitor REST API.
 * @author Marlon Packard Viza Quispe
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "AquaMonitor API", version = "1.0", description = "Water quality sampling plans"))
public class AquaMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AquaMonitorApplication.class, args);
    }
}
