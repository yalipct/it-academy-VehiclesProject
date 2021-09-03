package com.vehicles.project.nivel1;

import java.util.List;

import com.vehicles.project.exceptions.WheelsException;

public class Bike extends Vehicle {

	public Bike(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	
	public Bike() {
		super();
	}
	
	public void addWheels(Wheel frontWheel, Wheel backWheel) throws WheelsException {
		this.wheels.add(frontWheel);
		this.wheels.add(backWheel);
	}

	public void addTwoWheels(List<Wheel> wheels) throws WheelsException {	
		
		if(wheels.get(0).getDiameter()!=wheels.get(1).getDiameter()) {
			
			throw new WheelsException(WheelsException.RUEDAS_DISTINTAS);
		}
		
		this.wheels.add(wheels.get(0));
		this.wheels.add(wheels.get(1));		
	}

	@Override
	public String toString() {
		return "Bike [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels;
	}
	
	

}
