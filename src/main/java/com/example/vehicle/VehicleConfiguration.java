package com.example.vehicle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.vehicle.repository.VehicleRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.List;

@Configuration
@EnableJpaRepositories("com.example.vehicle.repository")
public class VehicleConfiguration {

    private final VehicleRepository vehicleRepository;

    public VehicleConfiguration(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Bean
    public CommandLineRunner initDatabase() {
        return args -> {
            List<Vehicle> vehicles = loadJsonData();

            vehicleRepository.saveAll(vehicles);

            System.out.println("Sample database initialized");
        };
    }

    private List<Vehicle> loadJsonData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            ClassPathResource resource = new ClassPathResource("data.json");
            VehiclesContainer vehiclesContainer = objectMapper.readValue(resource.getInputStream(), VehiclesContainer.class);

            return vehiclesContainer.getVehicles();
        } catch (IOException e) {
            throw new RuntimeException("Fehler beim Laden der JSON-Daten", e);
        }
    }
   
}
