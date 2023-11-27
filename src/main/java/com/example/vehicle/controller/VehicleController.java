package com.example.vehicle.controller;

import com.example.vehicle.service.VehicleService;
import com.example.vehicle.Vehicle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Vehicle>>> getAllVehicles() {
        List<EntityModel<Vehicle>> vehicles = vehicleService.getAllVehicles();
        return new ResponseEntity<>(CollectionModel.of(vehicles), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Vehicle>> getVehicleById(@PathVariable("id") Integer id) {
        EntityModel<Vehicle> vehicle = vehicleService.getVehicleById(id);
        return vehicle != null
                ? new ResponseEntity<>(vehicle, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable("id") Integer id) {
        return new ResponseEntity<>(vehicleService.deleteVehicle(id), HttpStatus.OK);
    }
}
