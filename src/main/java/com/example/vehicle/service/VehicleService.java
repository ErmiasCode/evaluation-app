package com.example.vehicle.service;

import com.example.vehicle.Vehicle;
import com.example.vehicle.controller.VehicleController;
import com.example.vehicle.repository.VehicleRepository;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }
    
    public List<EntityModel<Vehicle>> getAllVehicles() {
        return getAllVehicles1();
    }

    public List<EntityModel<Vehicle>> getAllVehicles1() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        return vehicles.stream()
                .map(vehicle -> EntityModel.of(vehicle,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VehicleController.class).getVehicleById(vehicle.getId())).withSelfRel()))
                .collect(Collectors.toList());
    }

    public EntityModel<Vehicle> getVehicleById(Integer id) {
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        return vehicleOptional.map(vehicle ->
                EntityModel.of(vehicle,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VehicleController.class).getVehicleById(id)).withSelfRel()))
                .orElse(null);
    }

    public String deleteVehicle(Integer id) {
        vehicleRepository.deleteById(id);
        return "Vehicle with id " + id + " deleted successfully";
    }

}
