package com.vehicles.project.nivel1;
import java.util.List;

import com.vehicles.project.exceptions.WheelsException;

public class Car extends Vehicle {

	public Car(String plate, String brand, String color) {
		super(plate, brand, color);
	}
	public Car() {
		super();
	}

	public void addWheels(List<Wheel> frontWheels, List<Wheel> backWheels) throws WheelsException {
		addTwoWheels(frontWheels);
		addTwoWheels(backWheels);
	}

	public void addTwoWheels(List<Wheel> wheels) throws WheelsException {
		if (wheels.size() != 2)
			throw new WheelsException(WheelsException.MAXIMO_RUEDAS);

		Wheel rightWheel = wheels.get(0);
		Wheel leftWheel = wheels.get(1);

		if (wheels.get(0).getDiameter()!=wheels.get(1).getDiameter())
			throw new WheelsException(WheelsException.RUEDAS_DISTINTAS);

		this.wheels.add(leftWheel);
		this.wheels.add(rightWheel);
	}
	
	@Override
	public String toString() {
		return "Car [plate=" + plate + ", brand=" + brand + ", color=" + color + ", wheels=" + wheels;
	}
	
}
