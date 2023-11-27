package com.example.vehicle;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.vehicle.repository.VehicleRepository;

@DataJpaTest
public class VehicleRepositoryTests {
	@Autowired 
	private VehicleRepository repo;
	
	
}
