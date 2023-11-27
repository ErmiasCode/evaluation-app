package com.example.vehicle;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vehicles")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String vehicleType;
	private String created;
	private String mileage;
	private String gearbox;
	private Integer owner;
	private String kwAndPs;
	private double hek;
	private String taxation;
	
    public Vehicle() {
    }

    @JsonCreator
    public Vehicle(
            @JsonProperty("vehicleType") String vehicleType,
            @JsonProperty("created") String created,
            @JsonProperty("mileage") String mileage,
            @JsonProperty("gearbox") String gearbox,
            @JsonProperty("owner") int owner,
            @JsonProperty("kwAndPs") String kwAndPs,
            @JsonProperty("hek") double hek,
            @JsonProperty("taxation") String taxation) {
        this.vehicleType = vehicleType;
        this.created = created;
        this.mileage = mileage;
        this.gearbox = gearbox;
        this.owner = owner;
        this.kwAndPs = kwAndPs;
        this.hek = hek;
        this.taxation = taxation;
    }
	
	
	public Vehicle(String string, String string2, String string3, String string4, int i, String string5, double j) {
	}

	public Integer getId() {
		return id;		
	}
	
	public String getVehicleType() {
		return vehicleType;
	}
	
	public String getCreated() {
		return created;
	}
	
	public String getMileage() {
		return mileage;
	}
	
	public String getGearbox() {
		return gearbox;
	}
	
	public Integer getOwner() {
		return owner;
	}
	
	public String getKwAndPs() {
		return kwAndPs;
	}
	
	public Double getHek() {
		return hek;
	}
	
	public String getTaxation() {
		return taxation;
	}


}
